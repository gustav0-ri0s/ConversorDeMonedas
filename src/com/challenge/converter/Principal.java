package com.challenge.converter;

import com.challenge.converter.service.ExchangeRateClient;

public class Principal {
    public static void main(String[] args) {
        ExchangeRateClient client = new ExchangeRateClient();
        String respuesta = client.obtenerJson("USD");
        System.out.println("Respuesta JSON:");
        System.out.println(respuesta);
    }
}
