package com.apigus.client;

import cis.bir.publ._2014._07.IUslugaBIRzewnPubl;
import org.springframework.stereotype.Component;
import org.tempuri.UslugaBIRzewnPubl;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.soap.AddressingFeature;
import java.util.ArrayList;
import java.util.List;

@Component
public class SoapClient {
    private volatile static SoapClient instance;

    private final String SESSION_STATUS = "StatusUslugi";
    private final String USER_KEY = "abcde12345abcde12345";

    private SoapMessageHandler soapMessageHandler;

    private IUslugaBIRzewnPubl client;

    public SoapClient() {
        this.soapMessageHandler = new SoapMessageHandler();
        this.client = prepareClient();

    }

    public IUslugaBIRzewnPubl getClient() {
        return client;
    }

    public static SoapClient getInstance() {
        if (instance == null) {
            synchronized (SoapClient.class) {
                if (instance == null) {
                    instance = new SoapClient();
                }
            }
        }

        return instance;
    }

    private IUslugaBIRzewnPubl prepareClient() {
        UslugaBIRzewnPubl service = new UslugaBIRzewnPubl();

        service.setHandlerResolver(portInfo -> {
            List<Handler> handlers = new ArrayList<>();
            handlers.add(soapMessageHandler);
            return handlers;
        });

        IUslugaBIRzewnPubl port = service.getE3(new AddressingFeature());
        final String sessionStatus = port.getValue(SESSION_STATUS);

        // logowanie, jezeli sesja wygasla, badx logowanie pierwszy raz
        if ((this.soapMessageHandler.getSessionCookie().equals("")) || (!sessionStatus.equals("1"))) {
            String sid = port.zaloguj(USER_KEY);
            this.soapMessageHandler.setSessionCookie(sid);
        }

        return port;
    }
}
