package com.example.demo.service;


import com.example.demo.exception.*;
import com.example.demo.model.DailyStock;
import com.example.demo.model.IntraStock;
import com.example.demo.model.StockQuote;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

public interface IStockService {
    StockQuote quote(String symbol) throws InvalidQuoteSymbolException,UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;
    List<IntraStock> intraDay(String symbol, Map<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<DailyStock> daily(String symbol, Map<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<DailyStock> dailyAdjustedClose(String symbol, Map<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<DailyStock> weekly(String symbol, Map<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<DailyStock> weeklyAdjusted(String symbol, Map<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<DailyStock> monthly(String symbol, Map<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<DailyStock> monthlyAdjusted(String symbol, Map<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

}
