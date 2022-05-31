package com.solvd.Uver.service;

import com.solvd.Uver.entities.Order;
import com.solvd.Uver.exception.DAOException;

import java.util.List;

public interface OrderService {
    void give(Order a) throws DAOException;

    void delete(int id);

    void modify(Order entities);

    Order getOne(int id);

    List<Order> getAll();
}
