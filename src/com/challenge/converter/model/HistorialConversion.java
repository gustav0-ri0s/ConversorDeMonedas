package com.challenge.converter.model;

public class HistorialConversion {
    private String monedaOrigen;
    private String monedaDestino;
    private double montoOriginal;
    private double tipoCambio;
    private double montoConvertido;
    private String fechaHora;

    public HistorialConversion(String monedaOrigen, String monedaDestino, double montoOriginal,
                               double tipoCambio, double montoConvertido, String fechaHora) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.montoOriginal = montoOriginal;
        this.tipoCambio = tipoCambio;
        this.montoConvertido = montoConvertido;
        this.fechaHora = fechaHora;
    }

    // Getters y setters opcionales si usarás GSON con deserialización
}
