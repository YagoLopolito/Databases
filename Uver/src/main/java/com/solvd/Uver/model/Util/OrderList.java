package com.solvd.Uver.model.Util;

import com.solvd.Uver.model.Order;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlRootElement(name="orderList")
@XmlType(propOrder = {"name", "orders"})
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
@XmlElementWrapper(name="orders")
@XmlElement(name="order")
    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}
