package com.gabodev.concesionario.model.part;

import com.gabodev.concesionario.enums.PartState;

public class Suspension extends PartTypeBase {

    private int suspensionHeight;

    public Suspension(String partName, PartState partState, int suspensionHeight) {
        super(partName, partState);
        this.suspensionHeight = suspensionHeight;
    }

    public int getSuspensionHeight() {
        return suspensionHeight;
    }

    @Override
    public void accept(PartVisitor partVisitor) {
        partVisitor.visit(this);
    }
}
