package com.solvd.Uver.service.daoServices;


import com.solvd.Uver.entities.SuperCar;
import com.solvd.Uver.exception.DAOException;

import java.net.ConnectException;
import java.util.List;

public interface SuperCarService {
    void insert(SuperCar a) throws DAOException, ConnectException;

    void deleteById(int id) throws DAOException, ConnectException;

    void update(SuperCar a) throws DAOException, ConnectException;

    SuperCar getById(int id) throws DAOException, ConnectException;

    List<SuperCar> getAll() throws DAOException, ConnectException;
}
