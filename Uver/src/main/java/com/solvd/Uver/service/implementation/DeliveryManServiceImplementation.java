package com.solvd.Uver.service.implementation;

import com.solvd.Uver.daos.DeliveryManDAO;
import com.solvd.Uver.daos.implementation.MySQLDeliveryManDAO;
import com.solvd.Uver.entities.DeliveryMan;
import com.solvd.Uver.exception.DAOException;
import com.solvd.Uver.service.DeliveryManService;

import java.sql.Connection;
import java.util.List;

public class DeliveryManServiceImplementation implements DeliveryManService {
    private final Connection conn;

    public DeliveryManServiceImplementation(Connection conn) {
        this.conn = conn;
    }


    @Override
    public void delete(int a) throws DAOException {
        DeliveryManDAO dm = new MySQLDeliveryManDAO(conn);
        dm.delete(a);
    }

    @Override
    public DeliveryMan getOne(int id) {
        DeliveryManDAO dm = new MySQLDeliveryManDAO(conn);
        DeliveryMan delivery = null;
        try {
            delivery = dm.give(id);

        } catch (DAOException e) {
            e.printStackTrace();
        }
        return delivery;
    }

    @Override
    public List<DeliveryMan> getAll() {
        DeliveryManDAO dm = new MySQLDeliveryManDAO(conn);
        List<DeliveryMan> deliveryList = null;
        try {
            deliveryList = dm.giveAll();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return deliveryList;
    }

    @Override
    public void give(DeliveryMan a) throws DAOException {
        DeliveryManDAO dms = new MySQLDeliveryManDAO(conn);
        dms.insert(a);
    }

    @Override
    public void modify(DeliveryMan a) throws DAOException {
        DeliveryManDAO dm = new MySQLDeliveryManDAO(conn);
        dm.modify(a);
    }


}
