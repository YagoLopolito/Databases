package com.solvd.Uver.model;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlRootElement(name="order")
@XmlType(propOrder = {"idOrder", "distance", "mailing", "driver", "destination", "estimatedTimeOfArrival"})
public class Order {
    int idOrder, estimatedTimeOfArrival, distance;
    String destination;
    boolean isMailing, isDriver;
    public Order() {
    }

    public Order(int idOrder, int estimatedTimeOfArrival, int distance, String destination, boolean isMailing, boolean isDriver) {
        this.idOrder = idOrder;
        this.estimatedTimeOfArrival = estimatedTimeOfArrival;
        this.distance = distance;
        this.destination = destination;
        this.isMailing = isMailing;
        this.isDriver = isDriver;
    }
@XmlAttribute(name="idOrder")
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
    @XmlElement(name="mailing")
    public boolean isMailing() {
        return isMailing;
    }

    public void setMailing(boolean mailing) {
        isMailing = mailing;
    }
    @XmlElement(name="driver")
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
