package com.apigus.services;

import com.apigus.repository.CompanyRepository;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private final CompanyRepository repository;

    @Autowired
    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

    public JSONObject getCompanyByNip(String nip) {
        String soapData = repository.getCompanyByNip(nip);
        return XML.toJSONObject(soapData);
    }
}
