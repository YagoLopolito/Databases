package com.solvd.Uver.model;

public class Stations {
    int stationNum;
    String city;

    public Stations() {
    }

    public Stations(int stationNum, String city) {
        this.stationNum = stationNum;
        this.city = city;
    }

    public int getStationNum() {
        return stationNum;
    }

    public void setStationNum(int stationNum) {
        this.stationNum = stationNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Stations{" +
                "stationNum=" + stationNum +
                ", city='" + city + '\'' +
                '}';
    }
}