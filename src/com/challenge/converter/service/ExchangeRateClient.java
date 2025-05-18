package com.challenge.converter.service;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ExchangeRateClient {

    private final HttpClient client;

    public ExchangeRateClient() {
        this.client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10)) //Tiempo máximo de espera 10 seg.
                .build();
    }

    public String obtenerJson(String baseCurrency) {
        String apiKey = "f334ac38203a36d22057701f";
        String url = "https://v6.exchangerate-api.com/v6/"+apiKey+"/latest/"+baseCurrency;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofSeconds(10)) //Tiempo de espera para la solicitud
                .header("User-Agent", "Java Conversor de moneda - Challenge") // Buenas prácticas
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return response.body();
            } else {
                System.out.println("Error: código de estado HTTP: " + response.statusCode());
                return null;
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Error al obtener datos de la API: "+e.getMessage());
            return null;
        }
    }
}
