package com.solvd.Uver.entities;

import java.util.Objects;

public class SuperMotorcycle {
    int idSuperMotorcycle, maxSpeed;
    String make, model;

    public SuperMotorcycle(String make, String model, Integer maxSpeed) {
    }

    public SuperMotorcycle(int idSuperMotorcycle, int maxSpeed, String make, String model) {
        this.idSuperMotorcycle = idSuperMotorcycle;
        this.maxSpeed = maxSpeed;
        this.make = make;
        this.model = model;
    }

    public int getIdSuperMotorcycle() {
        return idSuperMotorcycle;
    }

    public void setIdSuperMotorcycle(int idSuperMotorcycle) {
        this.idSuperMotorcycle = idSuperMotorcycle;
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
        SuperMotorcycle that = (SuperMotorcycle) o;
        return idSuperMotorcycle == that.idSuperMotorcycle && maxSpeed == that.maxSpeed && Objects.equals(make, that.make) && Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSuperMotorcycle, maxSpeed, make, model);
    }

    @Override
    public String toString() {
        return "SuperMotorcycles{" +
                "idSuperMotorcycle=" + idSuperMotorcycle +
                ", maxSpeed=" + maxSpeed +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
