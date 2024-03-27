package com.gabodev.concesionario.model.part;

import com.gabodev.concesionario.enums.PartState;


public class Engine extends PartTypeBase {

    private int engineCV;

    public Engine(String partName, PartState partState, int engineCV) {
        super(partName, partState);
        this.engineCV = engineCV;
    }

    public int getEngineCV() {
        return engineCV;
    }

    @Override
    public void accept(PartVisitor partVisitor) {
        partVisitor.visit(this);
    }
}
