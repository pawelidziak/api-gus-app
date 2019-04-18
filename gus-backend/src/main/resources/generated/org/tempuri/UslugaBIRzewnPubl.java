package org.tempuri;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import cis.bir.publ._2014._07.IUslugaBIRzewnPubl;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2019-04-18T18:35:16.355+02:00
 * Generated source version: 3.2.1
 * 
 */
@WebServiceClient(name = "UslugaBIRzewnPubl", 
                  wsdlLocation = "file:/D:/Workspace/api-gus-app/gus-backend/src/main/resources/UslugaBIRzewnPubl.xsd",
                  targetNamespace = "http://tempuri.org/") 
public class UslugaBIRzewnPubl extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://tempuri.org/", "UslugaBIRzewnPubl");
    public final static QName E3 = new QName("http://tempuri.org/", "e3");
    static {
        URL url = null;
        try {
            url = new URL("file:/D:/Workspace/api-gus-app/gus-backend/src/main/resources/UslugaBIRzewnPubl.xsd");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(UslugaBIRzewnPubl.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/D:/Workspace/api-gus-app/gus-backend/src/main/resources/UslugaBIRzewnPubl.xsd");
        }
        WSDL_LOCATION = url;
    }

    public UslugaBIRzewnPubl(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public UslugaBIRzewnPubl(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UslugaBIRzewnPubl() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public UslugaBIRzewnPubl(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public UslugaBIRzewnPubl(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public UslugaBIRzewnPubl(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns IUslugaBIRzewnPubl
     */
    @WebEndpoint(name = "e3")
    public IUslugaBIRzewnPubl getE3() {
        return super.getPort(E3, IUslugaBIRzewnPubl.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IUslugaBIRzewnPubl
     */
    @WebEndpoint(name = "e3")
    public IUslugaBIRzewnPubl getE3(WebServiceFeature... features) {
        return super.getPort(E3, IUslugaBIRzewnPubl.class, features);
    }

}
