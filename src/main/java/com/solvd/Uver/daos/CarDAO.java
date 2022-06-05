package com.solvd.Uver.daos;

import com.solvd.Uver.entities.Car;
import com.solvd.Uver.exception.DAOException;

import java.net.ConnectException;
import java.util.List;

public interface CarDAO extends DAO<Car, Integer> {

    @Override
    List<Car> getAll() throws DAOException, ConnectException;
}
