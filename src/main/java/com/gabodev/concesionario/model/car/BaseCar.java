package com.gabodev.concesionario.model.car;

import com.gabodev.concesionario.model.part.PartType;
import com.gabodev.concesionario.model.part.PartTypeBase;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class BaseCar {

    protected String brand;
    protected String model;
    protected int year;
    protected double price;
    protected String color;
    protected Boolean isOn;
    protected double speed;
    protected final double MAX_SPEED = 200;
    protected List<PartType> partsList;

    protected BaseCar(String brand, String model, int year, double price, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.color = color;
        this.isOn = false;
        this.speed = 0;
        this.partsList = new ArrayList<>();
    }

    public void turnOn() {

        if(isOn) {
            System.out.println("The car is already on");
        }
        else {
            this.isOn = true;
            System.out.println("The car is now on");
        }

    }

    public void turnOff() {

        if(isOn) {
            this.isOn = false;
            System.out.println("The car is now off");
        }
        else {
            System.out.println("The car is already off");
        }

    }

    public void addPart(PartType part) {
        partsList.add(part);
    }

    public abstract void accelerate();

    public abstract void brake();

    public abstract void decelerate();

    public abstract void turnRight();

    public abstract void turnLeft();

    public abstract void doTrainingRace();


}
