package com.gabodev.concesionario.model.part;

import com.gabodev.concesionario.model.part.Engine;
import com.gabodev.concesionario.model.part.Suspension;
import com.gabodev.concesionario.model.part.Wheel;

public interface PartVisitor {
    void visit(Engine engine);
    void visit(Wheel wheel);
    void visit(Suspension suspension);
}
