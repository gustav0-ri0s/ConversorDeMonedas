package com.challenge.converter.service;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpResponse;

public class ExchangeRateClient {
    public String obtenerJson(String baseCurrency) {
        String apiKey = "f334ac38203a36d22057701f";
        String url = "https://v6.exchangerate-api.com/v6/"+apiKey+"/latest/"+baseCurrency;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro al obtener datos de la API: "+e.getMessage());
            return null;
        }
    }
}
