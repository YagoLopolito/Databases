package com.solvd.Uver.entities;

import java.util.Objects;

public class Moto {
    int idCar, maxSpeed;
    String make, model;

    public Moto(String make, String model, Integer maxSpeed) {
    }

    public Moto(int idCar, int maxSpeed, String make, String model) {
        this.idCar = idCar;
        this.maxSpeed = maxSpeed;
        this.make = make;
        this.model = model;
    }

    public Moto() {

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
        Moto moto = (Moto) o;
        return idCar == moto.idCar && maxSpeed == moto.maxSpeed && Objects.equals(make, moto.make) && Objects.equals(model, moto.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCar, maxSpeed, make, model);
    }

    @Override
    public String toString() {
        return  "\n----------------------------------------------------------------\n"
                +"Moto" + "\nId moto: " + idCar
                + "\nMake: " + make
                + "\nModel: " + model
                + "\nMax speed: " + maxSpeed
                + "\n----------------------------------------------------------------\n"
                ;
    }
}
