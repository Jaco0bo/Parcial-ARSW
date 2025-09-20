package com.example.demo.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class AlphaVantageService {

    private static final String API_KEY = "XRRHFDFENJ5LBKEL";
    private static final String BASE_URL = "https://www.alphavantage.co/query";

    private final RestTemplate restTemplate;

    public AlphaVantageService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable(value = "stockCache", key = "#symbol")
    public String getStockData(String symbol, String interval) {
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .queryParam("function", "TIME_SERIES_INTRADAY")
                .queryParam("symbol", symbol)
                .queryParam("interval", interval)
                .queryParam("apikey", API_KEY)
                .toUriString();

        return restTemplate.getForObject(url, String.class);
    }
}
