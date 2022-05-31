package com.solvd.Uver.entities;

import java.util.Objects;

public class Garage {
    int idGarage, stationNum, carsCapacity, motorcycleCapacity;

    public Garage() {
    }

    public Garage(int idGarage, int stationNum, int carsCapacity, int motorcycleCapacity) {
        this.idGarage = idGarage;
        this.stationNum = stationNum;
        this.carsCapacity = carsCapacity;
        this.motorcycleCapacity = motorcycleCapacity;
    }

    public int getIdGarage() {
        return idGarage;
    }

    public void setIdGarage(int idGarage) {
        this.idGarage = idGarage;
    }

    public int getStationNum() {
        return stationNum;
    }

    public void setStationNum(int stationNum) {
        this.stationNum = stationNum;
    }

    public int getCarsCapacity() {
        return carsCapacity;
    }

    public void setCarsCapacity(int carsCapacity) {
        this.carsCapacity = carsCapacity;
    }

    public int getMotorcycleCapacity() {
        return motorcycleCapacity;
    }

    public void setMotorcycleCapacity(int motorcycleCapacity) {
        this.motorcycleCapacity = motorcycleCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Garage garage = (Garage) o;
        return idGarage == garage.idGarage && stationNum == garage.stationNum && carsCapacity == garage.carsCapacity && motorcycleCapacity == garage.motorcycleCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGarage, stationNum, carsCapacity, motorcycleCapacity);
    }

    @Override
    public String toString() {
        return "Garages{" +
                "idGarage=" + idGarage +
                ", stationNum=" + stationNum +
                ", carsCapacity=" + carsCapacity +
                ", motorcycleCapacity=" + motorcycleCapacity +
                '}';
    }
}
