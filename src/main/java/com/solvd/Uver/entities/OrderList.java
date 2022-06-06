package com.solvd.Uver.entities;


import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.Objects;

@XmlRootElement(name = "orderList")
public class OrderList {
    String name;
    private ArrayList<Order> orders = new ArrayList();

    public OrderList() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public ArrayList<Order> getOrders() {
        return orders;
    }

    @XmlElementWrapper(name = "orders")
    @XmlElement(name = "order")
    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderList orderList = (OrderList) o;
        return Objects.equals(name, orderList.name) && Objects.equals(orders, orderList.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, orders);
    }

    @Override
    public String toString() {
        return "OrderList{" +
                "name='" + name + '\'' +
                ", orders=" + orders +
                '}';
    }
}
