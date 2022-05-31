package com.solvd.Uver.service.implementation;

import com.solvd.Uver.daos.OrderDAO;
import com.solvd.Uver.daos.implementation.MySQLOrderDAO;
import com.solvd.Uver.entities.Order;
import com.solvd.Uver.exception.DAOException;
import com.solvd.Uver.service.OrderService;

import java.sql.Connection;
import java.util.List;

public class OrderServiceImplementation implements OrderService {
    private final Connection conn;

    public OrderServiceImplementation(Connection conn) {
        this.conn = conn;
    }


    @Override
    public void give(Order a) throws DAOException {
        OrderDAO ord = new MySQLOrderDAO(conn);
        ord.insert(a);
    }

    @Override
    public void delete(int a) throws DAOException {
        OrderDAO ord = new MySQLOrderDAO(conn);
        ord.delete(a);
    }

    @Override
    public void modify(Order a) throws DAOException {
        OrderDAO ord = new MySQLOrderDAO(conn);
        ord.modify(a);
    }

    @Override
    public Order getOne(int id) {
        return null;
    }

    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public List<Order> giveAll() throws DAOException {
        OrderDAO ord = new MySQLOrderDAO(conn);
        List<Order> orderList = null;
        orderList = ord.giveAll();
        return orderList;
    }

    @Override
    public Order give(Integer id) throws DAOException {
        OrderDAO ord = new MySQLOrderDAO(conn);
        Order order = null;
        order = ord.give(id);
        return order;
    }
}
