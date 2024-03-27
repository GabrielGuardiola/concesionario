package com.gabodev.concesionario.model.part;

import com.gabodev.concesionario.enums.PartState;

public abstract class PartTypeBase implements PartType {

    private String partName;
    private PartState partState;

    protected PartTypeBase(String partName, PartState partState) {
    }
    @Override
    public String getPartName() {
        return this.partName;
    }

    @Override
    public PartState getPartState() {
        return this.partState;
    }
}
