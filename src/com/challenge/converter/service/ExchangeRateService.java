package com.challenge.converter.service;

import com.challenge.converter.model.ExchangeRate;
import com.google.gson.Gson;

public class ExchangeRateService {
    private final Gson gson = new Gson();

    public ExchangeRate convertirDesdeJson(String json) {
        return gson.fromJson(json, ExchangeRate.class);
    }
}
