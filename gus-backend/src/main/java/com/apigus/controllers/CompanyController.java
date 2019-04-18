package com.apigus.controllers;


import com.apigus.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    @Autowired
    CompanyService service;

    @RequestMapping(value = "/getByNip", produces = "application/json")
    public String getCompanyDetail(@RequestParam(value="nip", defaultValue="7251801126") String nip) {
        return service.getComapnyDetaiulByNip(nip);
    }
}
