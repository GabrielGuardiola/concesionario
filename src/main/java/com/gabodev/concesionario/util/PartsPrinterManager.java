package com.gabodev.concesionario.util;

import com.gabodev.concesionario.model.part.Engine;
import com.gabodev.concesionario.model.part.PartVisitor;
import com.gabodev.concesionario.model.part.Suspension;
import com.gabodev.concesionario.model.part.Wheel;

public class PartsPrinterManager implements PartVisitor {

    @Override
    public void visit(Engine engine) {
        System.out.println("Engine: " + engine.getPartName() + " - " + engine.getEngineCV());
    }

    @Override
    public void visit(Wheel wheel) {
        System.out.println("Wheel: " + wheel.getPartName() + " - " + wheel.getWheelSize());

    }

    @Override
    public void visit(Suspension suspension) {
        System.out.println("Suspension: " + suspension.getPartName() + " - " + suspension.getSuspensionHeight());
    }
}
