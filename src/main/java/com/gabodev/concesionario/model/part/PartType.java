package com.gabodev.concesionario.model.part;

import com.gabodev.concesionario.enums.PartState;

public interface PartType {
    String getPartName();
    PartState getPartState();
    void accept(PartVisitor partVisitor);
}