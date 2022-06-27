package com.stackdeans.loginregister.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
public class CurrencyExchange {


    @GetMapping("/currency")
    public String getTheCurrency() throws IOException {


        final String uri = "https://v6.exchangerate-api.com/v6/5fe55f507f9b0d9688682b36/latest/USD";
//        final String uri = "https://v6.exchangerate-api.com/v6/5fe55f507f9b0d9688682b36/enriched/GBP/JPY";

//        https://v6.exchangerate-api.com/v6/5fe55f507f9b0d9688682b36/enriched/GBP/JPY
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);


//        final String uri = "https://v6.exchangerate-api.com/v6/5fe55f507f9b0d9688682b36/latest/USD";
//        ObjectMapper objectMapper = new ObjectMapper();
//        Map<String, List<Currency>> countryMap = objectMapper.readValue(uri,new TypeReference<Map<String, List<Currency>>>(){});
//

        System.out.println(result);
        return result;
    }


}
