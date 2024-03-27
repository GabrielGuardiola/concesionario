package com.gabodev.concesionario.model.part;

import com.gabodev.concesionario.enums.PartState;

public class Wheel extends PartTypeBase{

    private int wheelSize;

    public Wheel(String partName, PartState partState, int wheelSize) {
        super(partName, partState);
        this.wheelSize = wheelSize;
    }

    public int getWheelSize() {
        return wheelSize;
    }

    @Override
    public void accept(PartVisitor partVisitor) {
        partVisitor.visit(this);
    }
}
