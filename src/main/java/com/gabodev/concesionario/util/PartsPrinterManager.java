package com.gabodev.concesionario.util;

import com.gabodev.concesionario.model.part.Engine;
import com.gabodev.concesionario.model.part.Suspension;
import com.gabodev.concesionario.model.part.Wheel;

public class PartsPrinterManager {

    public void print(Wheel wheel){
        System.out.println("Wheel: " + wheel.getPartName() + " - " + wheel.getWheelSize());
    }

    public void print(Engine engine){
        System.out.println("Engine: " + engine.getPartName() + " - " + engine.getEngineCV());
    }

    public void print(Suspension suspension){
        System.out.println("Suspension: " + suspension.getPartName() + " - " + suspension.getSuspensionHeight());
    }
}
