package com.solvd.Uver.service;

import com.solvd.Uver.entities.Order;
import com.solvd.Uver.exception.DAOException;

import java.util.List;

public interface OrderService {
    void give(Order a) throws DAOException;

    void delete(int id) throws DAOException;

    void modify(Order entities) throws DAOException;

    Order getOne(int id) throws DAOException;

    List<Order> getAll() throws DAOException;
}
