package com.solvd.Uver.service;

import com.solvd.Uver.entities.DeliveryMan;
import com.solvd.Uver.exception.DAOException;

import java.util.List;

public interface DeliveryManService {

    void give(DeliveryMan a) throws DAOException;

    void modify(DeliveryMan entities) throws DAOException;

    void delete(int id) throws DAOException;

    DeliveryMan getOne(int id);

    List<DeliveryMan> getAll();

}
