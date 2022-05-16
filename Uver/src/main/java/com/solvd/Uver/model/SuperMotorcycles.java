package com.solvd.Uver.model;

public class SuperMotorcycles {
    int idSuperMotorcycle, maxSpeed;
    String make, model;

    public SuperMotorcycles() {
    }

    public SuperMotorcycles(int idSuperMotorcycle, int maxSpeed, String make, String model) {
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
    public String toString() {
        return "SuperMotorcycles{" +
                "idSuperMotorcycle=" + idSuperMotorcycle +
                ", maxSpeed=" + maxSpeed +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
