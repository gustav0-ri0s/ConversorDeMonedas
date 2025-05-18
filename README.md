# 💱 Conversor de Monedas en Java

Este es un proyecto Java que permite consultar tasas de cambio en tiempo real y realizar conversiones entre distintas divisas utilizando la API de [ExchangeRate-API](https://www.exchangerate-api.com/).

## 🚀 Funcionalidades

- ✅ Consulta en tiempo real de tasas de cambio.
- ✅ Conversión de montos entre dos monedas (por código).
- ✅ Formato de salida personalizado según la moneda.
- ✅ Registro histórico de conversiones en archivo `historial.json`.
- ✅ Interfaz de consola simple y clara.
- ✅ Validación de entrada de usuario.

## 📦 Estructura del Proyecto

```plaintext
src/
└── com/
    └── challenge/
        └── converter/
            ├── model/
            │   ├── ExchangeRate.java
            │   └── HistorialConversion.java
            ├── service/
            │   ├── ExchangeRateClient.java
            │   ├── ExchangeRateService.java
            │   └── ConversorMoneda.java
            ├── util/
            │   └── Menu.java
            └── Principal.java
```

## 🛠️ Requisitos

- Java 17 o superior.
- Conexión a internet (para consumir la API).

**Dependencias externas:**

- [Gson](https://github.com/google/gson) (para parsear respuestas JSON).

---

## 🔐 API Key

El sistema usa la API pública de ExchangeRate API.

La clave se incluye como constante en la clase:
Debes tener una clave de API válida de [ExchangeRate API](https://www.exchangerate-api.com/).


## 🧪 Ejecución

Puedes ejecutar el programa desde tu IDE favorito o por terminal:

```bash
javac -d bin src/com/challenge/converter/*.java src/com/challenge/converter/**/*.java
java -cp bin com.challenge.converter.Principal
```

## 🧮 Ejemplo de Uso

1. Se muestran las monedas disponibles y sus códigos.
   ![image](https://github.com/user-attachments/assets/322d9bb3-23cd-4cc9-b811-95eca63f1663)

2. Ingresas el código de la moneda origen, moneda destino y el monto a convertir.
![image](https://github.com/user-attachments/assets/00d805f8-69e0-490a-be50-f9a64c2c44e5)

3. El sistema realiza la conversión, muestra el resultado y lo guarda en un historial JSON:
```plaintext
[
  {
    "monedaOrigen": "USD",
    "monedaDestino": "PEN",
    "montoOriginal": 500.0,
    "tipoCambio": 3.78,
    "montoConvertido": 1890.0,
    "fechaHora": "17/05/2025 23:30:12"
  }
]

```

---

## 📌 Notas

- Solo se aceptan códigos de moneda válidos de 3 letras (ej. USD, PEN, MXN).
- Los montos se formatean automáticamente según el país de destino ($, S/, etc.).
- El historial se guarda como un array JSON válido.

---

## 📄 Licencia

Este proyecto es de uso libre para fines educativos o personales.

---

## 👨‍💻 Desarrollado con ❤️ en Java.
