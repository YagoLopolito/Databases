package com.solvd.Uver.entities;

import java.util.Objects;

public class Bill {
    int idBill, estimatedTimeOfArrival, distance, price;
    String destination;
    boolean isMailing, isDriver;

    public Bill() {

    }

    public Bill(int idBill, int estimatedTimeOfArrival, int distance, int price, String destination, boolean isMailing, boolean isDriver) {
        this.idBill = idBill;
        this.estimatedTimeOfArrival = estimatedTimeOfArrival;
        this.distance = distance;
        this.price = price;
        this.destination = destination;
        this.isMailing = isMailing;
        this.isDriver = isDriver;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public int getEstimatedTimeOfArrival() {
        return estimatedTimeOfArrival;
    }

    public void setEstimatedTimeOfArrival(int estimatedTimeOfArrival) {
        this.estimatedTimeOfArrival = estimatedTimeOfArrival;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public boolean isMailing() {
        return isMailing;
    }

    public void setMailing(boolean mailing) {
        isMailing = mailing;
    }

    public boolean isDriver() {
        return isDriver;
    }

    public void setDriver(boolean driver) {
        isDriver = driver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return idBill == bill.idBill && estimatedTimeOfArrival == bill.estimatedTimeOfArrival && distance == bill.distance && price == bill.price && isMailing == bill.isMailing && isDriver == bill.isDriver && Objects.equals(destination, bill.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBill, estimatedTimeOfArrival, distance, price, destination, isMailing, isDriver);
    }

    @Override
    public String toString() {
        return "Bill{" +
                "idBill=" + idBill +
                ", estimatedTimeOfArrival=" + estimatedTimeOfArrival +
                ", distance=" + distance +
                ", price=" + price +
                ", destination='" + destination + '\'' +
                ", isMailing=" + isMailing +
                ", isDriver=" + isDriver +
                '}';
    }
}
