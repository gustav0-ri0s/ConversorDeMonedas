package com.challenge.converter;

import com.challenge.converter.model.ExchangeRate;
import com.challenge.converter.service.ConversorMoneda;
import com.challenge.converter.service.ExchangeRateClient;
import com.challenge.converter.service.ExchangeRateService;
import com.challenge.converter.util.Menu;

import java.util.Scanner;


public class Principal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Menu menu = new Menu();
        String opcion;

        do{
            menu.mostrarMenu();

            String monedaOrigen = menu.obtenerMoneda("origen");
            String monedaDestino = menu.obtenerMoneda("destino");
            double monto = menu.obtenerMonto(monedaOrigen);

            ExchangeRateClient client = new ExchangeRateClient();
            String json = client.obtenerJson(monedaOrigen);

            if (json != null) {
                ExchangeRateService service = new ExchangeRateService();
                ExchangeRate datos = service.convertirDesdeJson(json);

                ConversorMoneda conversor = new ConversorMoneda();
                conversor.mostrarConversion(datos, monedaOrigen, monedaDestino, monto);
            } else {
                System.out.println("No se pudo obtener información de la API.");
            }

            //Menu
            System.out.println("========================================");
            System.out.println("Bienvenido(a) al Conversor de Monedas.");
            System.out.println("========================================");
            System.out.println("a. Realizar otra conversión");
            System.out.println("s. Salir");
            System.out.print("Seleccione la opción deseada (a, s): ");
            opcion = scanner.nextLine().trim().toLowerCase();
        } while (!opcion.equals("s"));
        System.out.println("\nGracias por utilizar el Conversor de Monedas.");



    }
}
