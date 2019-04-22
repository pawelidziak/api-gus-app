package com.apigus.services;

import org.json.JSONObject;

public interface ICompanyService {
   JSONObject getByNip(String nip);
}
