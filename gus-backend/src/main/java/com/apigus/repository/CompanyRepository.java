package com.apigus.repository;


import com.apigus.client.SoapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import cis.bir.publ._2014._07.datacontract.ObjectFactory;
import cis.bir.publ._2014._07.datacontract.ParametryWyszukiwania;

import javax.xml.bind.JAXBElement;

@Repository
public class CompanyRepository implements ICompanyRepository {

    private final SoapClient client;

    @Autowired
    public CompanyRepository(SoapClient client) {
        this.client = client;
    }

    @Override
    public String getByNip(String nip) {
        ParametryWyszukiwania params = this.createNipSearchParameter(nip);
        return client.getClient().daneSzukaj(params);
    }

    private ParametryWyszukiwania createNipSearchParameter(String nip) {
        ObjectFactory objectFactory = new ObjectFactory();
        JAXBElement<String> nipParam = objectFactory.createParametryWyszukiwaniaNip(nip);
        ParametryWyszukiwania parametryWyszukiwania = new ParametryWyszukiwania();
        parametryWyszukiwania.setNip(nipParam);
        return parametryWyszukiwania;
    }
}
