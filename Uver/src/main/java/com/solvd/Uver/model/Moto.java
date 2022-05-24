package com.solvd.Uver.model;

public class Moto {
    int idCar, maxSpeed;
    String make, model;

    public Moto() {
    }

    public Moto(int idCar, int maxSpeed, String make, String model) {
        this.idCar = idCar;
        this.maxSpeed = maxSpeed;
        this.make = make;
        this.model = model;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
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
        return "Moto{" +
                "idCar=" + idCar +
                ", maxSpeed=" + maxSpeed +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
