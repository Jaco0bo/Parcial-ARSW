package com.example.demo.controllers;

import com.example.demo.service.AlphaVantageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    private final AlphaVantageService alphaVantageService;

    public StockController(AlphaVantageService alphaVantageService) {
        this.alphaVantageService = alphaVantageService;
    }

    @GetMapping("/{symbol}")
    public ResponseEntity<String> getStockData(@PathVariable String symbol, @RequestParam String interval) {
        String stockData = alphaVantageService.getStockData(symbol, interval);
        return ResponseEntity.ok(stockData);
    }
}
