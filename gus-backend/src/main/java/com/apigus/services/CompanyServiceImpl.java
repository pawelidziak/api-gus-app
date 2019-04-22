package com.apigus.services;

import com.apigus.repository.CompanyRepository;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements ICompanyService {

    private final CompanyRepository repository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    public JSONObject getByNip(String nip) {
        String soapData = repository.getByNip(nip);
        JSONObject jsonData = XML.toJSONObject(soapData);
        return prepareJSONObject(jsonData);
    }

    private JSONObject prepareJSONObject(JSONObject jsonData) {
        if (jsonData.has("root") && jsonData.getJSONObject("root").has("dane")) {
            jsonData = jsonData.getJSONObject("root").getJSONObject("dane");
        }
        return jsonData;
    }
}
