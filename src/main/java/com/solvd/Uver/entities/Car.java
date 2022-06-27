package com.solvd.Uver.entities;

import java.util.Objects;

public class Car {
    int idCar, maxSpeed;
    String make;
    String model;

    public Car(String make, String model, Integer maxSpeed) {
        this.make = make;
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public Car(int idCar, int maxSpeed, String make, String model) {
        this.idCar = idCar;
        this.maxSpeed = maxSpeed;
        this.make = make;
        this.model = model;
    }

    public Car() {

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return idCar == car.idCar && maxSpeed == car.maxSpeed && Objects.equals(make, car.make) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCar, maxSpeed, make, model);
    }

    @Override
    public String toString() {
        return "\n----------------------------------------------------------------\n"
                + "Car" + "\nId car: " + idCar
                + "\nMake: " + make
                + "\nModel: " + model
                + "\nMax speed: " + maxSpeed
                + "\n----------------------------------------------------------------"
                ;
    }

}
