package com.stackdeans.loginregister.controllers;

import com.stackdeans.loginregister.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeService currencyExchangeService;

    @GetMapping("/currency")
    public String getTheCurrency() throws IOException {
        return currencyExchangeService.getTheCurrency();
    }
}
