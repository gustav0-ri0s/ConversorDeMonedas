package com.challenge.converter.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);

    private final Map<String, String> monedas = new LinkedHashMap<>(){{
        put("USD", "Dólar Americano");
        put("MXN", "Peso Mexicano");
        put("BRL", "Real Brasileño");
        put("ARS", "Peso Argentino");
        put("PEN", "Sol Peruano");
        put("COP", "Peso Colombiano");
        put("CRC", "Colón Costarricense");
        put("GTQ", "Quetzal Guatemalteco");
        put("CLP", "Peso Chileno");
    }};

    public void mostrarMenu() {
        System.out.println("========================================");
        System.out.println("Conversor de Monedas ");
        System.out.println("========================================");
        for (Map.Entry<String, String> entry : monedas.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(), entry.getValue());
        }
        System.out.println("-------------------------------------------------");
    }

    public String obtenerMoneda(String tipo) {
        String codigo;
        do{
            System.out.printf("Ingrese la moneda %s (ej: USD, PEN): ", tipo);
            codigo = scanner.nextLine().trim().toUpperCase();
            if (!monedas.containsKey(codigo)) {
                System.out.println("Código de moneda inválido. Inténtelo de nuevo.");
            }
        } while (!monedas.containsKey(codigo));

        return codigo;
    }
    public double obtenerMonto(String codigoMoneda) {
        System.out.printf("Cantidad de %s a convertir: ",codigoMoneda);
        while ( !scanner.hasNextDouble()){
            System.out.print("Ingrese un número válido: ");
            scanner.next();
        }
        double monto = scanner.nextDouble();
        scanner.nextLine();
        return monto;
    }
}
