package com.solvd.Uver.entities;

import java.util.Objects;

public class SuperCar {
    int idSuperCar, maxSpeed;
    String make, model;

    public SuperCar(String make, String model, Integer maxSpeed) {
    }

    public SuperCar(int idSuperCar, int maxSpeed, String make, String model) {
        this.idSuperCar = idSuperCar;
        this.maxSpeed = maxSpeed;
        this.make = make;
        this.model = model;
    }

    public SuperCar() {

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperCar superCar = (SuperCar) o;
        return idSuperCar == superCar.idSuperCar && maxSpeed == superCar.maxSpeed && Objects.equals(make, superCar.make) && Objects.equals(model, superCar.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSuperCar, maxSpeed, make, model);
    }

    @Override
    public String toString() {
        return "\n----------------------------------------------------------------"
                + "\nSuper Car" + "\nId super car: " + idSuperCar
                + "\nMake: " + make
                + "\nModel: " + model
                + "\nMax speed: " + maxSpeed
                + "\n----------------------------------------------------------------\n"
                ;
    }
}
