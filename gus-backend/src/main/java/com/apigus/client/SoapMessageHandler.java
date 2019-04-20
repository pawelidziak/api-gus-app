package com.apigus.client;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.*;


/**
 * Class implemented based on below links
 * https://docs.oracle.com/cd/E14571_01/web.1111/e13734/handlers.htm#WSADV174
 * https://stackoverflow.com/questions/6666060/java-web-service-client-adding-http-headers
 */
public class SoapMessageHandler implements SOAPHandler<SOAPMessageContext> {
    private final String SID = "sid";
    private String sessionCookie;

    public SoapMessageHandler() {
        this.sessionCookie = "";
    }

    @Override
    public boolean handleMessage(SOAPMessageContext messageCtx) {
        Boolean outboundProperty = (Boolean) messageCtx.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (outboundProperty.booleanValue()) {
            Map<String, List<String>> reqHeaders = (Map<String, List<String>>) messageCtx.get(MessageContext.HTTP_REQUEST_HEADERS);
            if (reqHeaders == null) {
                reqHeaders = new HashMap<>();
                messageCtx.put(MessageContext.HTTP_REQUEST_HEADERS, reqHeaders);
            }
            reqHeaders.put(SID, Collections.singletonList(this.sessionCookie));
        }
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext messageContext) {
        return true;
    }

    @Override
    public void close(MessageContext messageContext) {
    }

    @Override
    public Set<QName> getHeaders() {
        return Collections.emptySet();
    }

    public void setSessionCookie(String sessionCookie) {
        this.sessionCookie = sessionCookie;
    }

    public String getSessionCookie() {
        return sessionCookie;
    }
}