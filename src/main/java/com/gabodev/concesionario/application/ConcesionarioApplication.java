package com.gabodev.concesionario.application;

import com.gabodev.concesionario.enums.PartState;
import com.gabodev.concesionario.model.car.FamilyCar;
import com.gabodev.concesionario.model.part.Engine;
import com.gabodev.concesionario.model.part.Suspension;
import com.gabodev.concesionario.model.part.Wheel;
import com.gabodev.concesionario.util.CarPrinterManager;

public class ConcesionarioApplication {

    private final CarPrinterManager carPrinterManager;

    public ConcesionarioApplication(CarPrinterManager carPrinterManager) {
        this.carPrinterManager = carPrinterManager;
    }

    public void run(){
        System.out.println("Concesionario application running");
        FamilyCar familyCar = new FamilyCar("Family Car", "Blue", 4, 4, "blue");

        familyCar.addPart(new Wheel("Michelin", PartState.NEW,17));
        familyCar.addPart(new Wheel("Michelin", PartState.NEW,17));
        familyCar.addPart(new Wheel("Michelin", PartState.NEW,17));
        familyCar.addPart(new Wheel("Michelin", PartState.NEW,17));
        familyCar.addPart(new Suspension("Suspension familiar", PartState.NEW, 10));
        familyCar.addPart(new Engine("Engine familiar", PartState.NEW, 100));

        familyCar.turnOn();

        carPrinterManager.print(familyCar);

    }

}
