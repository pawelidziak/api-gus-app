package com.apigus.controllers;


import com.apigus.config.AppConstants;
import com.apigus.errors.CompanyNotFoundErr;
import com.apigus.services.CompanyServiceImpl;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = AppConstants.FRONTEND_HOST)
public class CompanyController {

    private final CompanyServiceImpl service;

    @Autowired
    public CompanyController(CompanyServiceImpl service) {
        this.service = service;
    }

    @GetMapping(value = "/getByNip", produces = "application/json")
    public String getCompanyDetail(@RequestParam(value = "nip", defaultValue = "8971696669") String nip) {
        JSONObject response = service.getByNip(nip);
        if (!response.isEmpty()){
            return response.toString();
        }
        throw new CompanyNotFoundErr();
    }
}
