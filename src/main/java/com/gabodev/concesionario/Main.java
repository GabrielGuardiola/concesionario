package com.gabodev.concesionario;

import com.gabodev.concesionario.application.ConcesionarioApplication;
import com.gabodev.concesionario.util.CarPrinterManager;
import com.gabodev.concesionario.util.PartsPrinterManager;

public class Main {
    public static void main(String[] args) {
        ConcesionarioApplication concesionarioApplication = new ConcesionarioApplication(new CarPrinterManager(new PartsPrinterManager()));
        concesionarioApplication.run();
    }

}

//Por consola.
//
//Simular funcionalidad de un concesionario de coches
//- Comprar/vender
//- recibir visitas
//- stock de coches
//- stock de piezas
//- funcionalidad par probar coches
//	- arrancar
//	- girar
//	- recorrer una calle
//- Sistema de facturación para compras / reparaciones
//	- Importe de concepto * cantidad
//
//- Añadir o eliminar conceptos de una factura pero una vez emitida no se puede modificar.
//
//En el readme de la práctica - especificar dónde se ha aplicado los principios SOLID y por qué.