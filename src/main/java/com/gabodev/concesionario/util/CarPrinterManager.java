package com.gabodev.concesionario.util;

import com.gabodev.concesionario.model.car.FamilyCar;
import com.gabodev.concesionario.model.car.LuxuryCar;
import com.gabodev.concesionario.model.car.SportCar;
import com.gabodev.concesionario.model.part.Wheel;

public class CarPrinterManager {

    private final PartsPrinterManager partsPrinterManager;
    public CarPrinterManager(PartsPrinterManager partsPrinterManager) {

        this.partsPrinterManager = partsPrinterManager;
    }

    public void print(FamilyCar car){
        System.out.println("Family Car: " + car.getModel());

        for (int i = 0; i < car.getPartsList().size(); i++) {
            //print parts
            partsPrinterManager.print(car.getPartsList().get(i));
        }
    }

    public void print(LuxuryCar car){
        System.out.println("Luxury Car: " + car.getModel());
    }

    public void print(SportCar car){
        System.out.println("Sports Car: " + car.getModel());
    }

}
