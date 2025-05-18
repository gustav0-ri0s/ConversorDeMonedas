package com.challenge.converter.model;

import java.util.Map;

public class ExchangeRate {
    private String base_code;
    private Map<String, Double> conversion_rates;

    public String getBase_code() {
        return base_code;
    }

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }
}
