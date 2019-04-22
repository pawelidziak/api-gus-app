package com.apigus.errors;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Nie znaleziono. Sprawdź NIP.")
public class CompanyNotFoundErr extends RuntimeException {
}
