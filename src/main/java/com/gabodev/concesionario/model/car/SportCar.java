package com.gabodev.concesionario.model.car;

public class SportCar extends BaseCar {

    private final double MAX_SPEED = 400;
    public SportCar(String brand, String model, int year, double price, String color) {
        super(brand, model, year, price, color);
    }

    @Override
    public void accelerate() {

    }

    @Override
    public void brake() {

    }

    @Override
    public void decelerate() {

    }

    @Override
    public void turnRight() {

    }

    @Override
    public void turnLeft() {

    }

    @Override
    public void doTrainingRace() {

    }
}
