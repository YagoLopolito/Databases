package com.solvd.Uver.model;

public class SuperCar {
    int idSuperCar, maxSpeed;
    String make, model;

    public SuperCar() {
    }

    public SuperCar(int idSuperCar, int maxSpeed, String make, String model) {
        this.idSuperCar = idSuperCar;
        this.maxSpeed = maxSpeed;
        this.make = make;
        this.model = model;
    }

    public int getIdSuperCar() {
        return idSuperCar;
    }

    public void setIdSuperCar(int idSuperCar) {
        this.idSuperCar = idSuperCar;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "SuperCars{" +
                "idSuperCar=" + idSuperCar +
                ", maxSpeed=" + maxSpeed +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
