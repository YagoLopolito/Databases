package com.solvd.Uver.entities;

import java.util.Objects;

public class Station {
    int stationNum;
    String city;

    public Station() {
    }

    public Station(int stationNum, String city) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return stationNum == station.stationNum && Objects.equals(city, station.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stationNum, city);
    }

    @Override
    public String toString() {
        return "Stations{" +
                "stationNum=" + stationNum +
                ", city='" + city + '\'' +
                '}';
    }
}
