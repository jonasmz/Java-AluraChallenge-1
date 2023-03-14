## JMZ CurrencyConverter for Java AluraChallenge 1

Aplicacion para convertir divisas, que utiliza el servicio api [Exchange Rates](https://apilayer.com/marketplace/exchangerates_data-api)

Ademas incluye un conversor de bases numericas.

## Caracteristicas principales

El conversor de divisas permite convertir las siguien1tes divisas:

    * USD: Dolar Estadounidense
    * GBP: Libra esterlina
    * EUR: Euro
    * JPY: Yen Japones
    * KRW: Won Sur Coreano
    * ARS: Peso Argentino
    * BRL: Real Brasilero

Por su parte el conversor de bases numericas dispone de las siguientes bases:
   
    - DECIMAL
    - BINARIO
    - OCTAL
    - HEXADECIMAL

## NOTA IMPORTANTE

Para poder utilizar el conversor de divisas es importante que primero siga los sientes pasos:

    + Dirijase al sitio https://apilayer.com/marketplace/exchangerates_data-api y obtenga un subscripcion (Puede utilizar una subscripcion gratuita que le ofrece 250 peticiones mensuales)

    + Una vez obtenida la apiKey para Exchange Rates, adentro del paquete UI, insertale en la clase CCWindow.java, en el metodo convert. Alli se realiza una llamada al metodo setServiceApikey del cliente api.

    + Finalizado el paso anterior ya puede empezar a realizar peticiones a traves del conversor de divisas.


## ¡Que lo disfrutes!

![Crrency converter snapshot](/Snapshot.png "Currency Converter Snapshot")