package com.apigus.controllers;


import com.apigus.config.AppConstants;
import com.apigus.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = AppConstants.FRONTEND_HOST)
public class CompanyController {

    private final CompanyService service;

    @Autowired
    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @GetMapping(value = "/getByNip", produces = "application/json")
    public String getCompanyDetail(@RequestParam(value = "nip", defaultValue = "8971696669") String nip) {
        return service.getCompanyByNip(nip).toString();
    }
}
