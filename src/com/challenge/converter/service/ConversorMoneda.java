package com.challenge.converter.service;

import com.challenge.converter.model.ExchangeRate;
import com.challenge.converter.model.HistorialConversion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ConversorMoneda {
    public void mostrarConversion(ExchangeRate datos, String monedaOrigen, String monedaDestino, double monto) {
        Map<String, Double> tasas = datos.getConversion_rates();

        if (!tasas.containsKey(monedaDestino)) {
            System.out.println("La moneda destino no está disponible en la respuesta.");
            return;
        }
        double tasaCambio = tasas.get(monedaDestino);
        double resultado = monto * tasaCambio;

        NumberFormat formatoMonedaOrigen = NumberFormat.getCurrencyInstance(obtenerLocalePorMoneda(monedaOrigen));
        NumberFormat formatoMonedaDestino = NumberFormat.getCurrencyInstance(obtenerLocalePorMoneda(monedaDestino));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fechaHora = LocalDateTime.now().format(formatter);


        System.out.println("\n-------------------------------------------------");
        System.out.println("Datos de la conversión: ");
        System.out.println("Tipo de Cambio: " + tasaCambio);
        System.out.println("La cantidad de: " + formatoMonedaOrigen.format(monto) + " " + monedaOrigen);
        System.out.println("Corresponde a: " + formatoMonedaDestino.format(resultado) + " " + monedaDestino);
        System.out.println("Fecha y hora de conversión: " + fechaHora);
        System.out.println("-------------------------------------------------");

        // Guardar en historial JSON
        HistorialConversion historial = new HistorialConversion(
                monedaOrigen, monedaDestino, monto, tasaCambio, resultado, fechaHora);
        guardarConversionEnJson(historial);

    }
    private Locale obtenerLocalePorMoneda(String codigo) {
        return switch (codigo) {
            case "USD" -> Locale.US;
            case "PEN" -> new Locale("es", "PE");
            case "MXN" -> new Locale("es", "MX");
            case "ARS" -> new Locale("es", "AR");
            case "BRL" -> new Locale("pt", "BR");
            case "COP" -> new Locale("es", "CO");
            case "CLP" -> new Locale("es", "CL");
            case "CRC" -> new Locale("es", "CR");
            case "GTQ" -> new Locale("es", "GT");
            case "EUR" -> Locale.GERMANY; // o Locale.FRANCE si prefieres
            default -> Locale.US;
        };

    }

    private void guardarConversionEnJson(HistorialConversion nuevaConversion) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String rutaArchivo = "historial.json";
        List<HistorialConversion> historialExistente = new ArrayList<>();

        // Leer archivo si existe
        File archivo = new File(rutaArchivo);
        if (archivo.exists()) {
            try (Reader reader = new FileReader(archivo)) {
                Type listType = new TypeToken<List<HistorialConversion>>() {}.getType();
                historialExistente = gson.fromJson(reader, listType);
            } catch (IOException e) {
                System.out.println("⚠ Error al leer historial existente: " + e.getMessage());
            }
        }

        // Agregar nueva conversión
        historialExistente.add(nuevaConversion);

        // Guardar lista completa reescribiendo archivo
        try (Writer writer = new FileWriter(rutaArchivo)) {
            gson.toJson(historialExistente, writer);
            System.out.println("✅ Conversión agregada al historial.json (array JSON válido)");
        } catch (IOException e) {
            System.out.println("⚠ Error al guardar historial: " + e.getMessage());
        }
    }
}