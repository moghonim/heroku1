package com.stackdeans.loginregister.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class CurrencyExchangeService {

    public String getTheCurrency() throws IOException {
        final String uri = "https://v6.exchangerate-api.com/v6/5fe55f507f9b0d9688682b36/latest/USD";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        System.out.println(result);
        return result;
    }
}
