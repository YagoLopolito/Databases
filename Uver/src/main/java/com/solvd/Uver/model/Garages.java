package com.solvd.Uver.model;

public class Garages {
    int idGarage, stationNum, carsCapacity, motorcycleCapacity;

    public Garages() {
    }

    public Garages(int idGarage, int stationNum, int carsCapacity, int motorcycleCapacity) {
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
    public String toString() {
        return "Garages{" +
                "idGarage=" + idGarage +
                ", stationNum=" + stationNum +
                ", carsCapacity=" + carsCapacity +
                ", motorcycleCapacity=" + motorcycleCapacity +
                '}';
    }
}
