package com.solvd.Uver.model;

public class Orders {
    int idOrder, estimatedTimeOfArrival, distance;
    String destination;
    boolean isMailing, isDriver;

    public Orders() {
    }

    public Orders(int idOrder, int estimatedTimeOfArrival, int distance, String destination, boolean isMailing, boolean isDriver) {
        this.idOrder = idOrder;
        this.estimatedTimeOfArrival = estimatedTimeOfArrival;
        this.distance = distance;
        this.destination = destination;
        this.isMailing = isMailing;
        this.isDriver = isDriver;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
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
    public String toString() {
        return "Orders{" +
                "idOrder=" + idOrder +
                ", estimatedTimeOfArrival=" + estimatedTimeOfArrival +
                ", distance=" + distance +
                ", destination='" + destination + '\'' +
                ", isMailing=" + isMailing +
                ", isDriver=" + isDriver +
                '}';
    }
}
