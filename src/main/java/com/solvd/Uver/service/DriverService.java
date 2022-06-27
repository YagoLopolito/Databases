package com.solvd.Uver.service;

import com.solvd.Uver.entities.Driver;
import com.solvd.Uver.exception.DAOException;

import java.net.ConnectException;
import java.util.List;

public interface DriverService {
    void insert(Driver a) throws DAOException, ConnectException;

    void update(Driver a) throws DAOException, ConnectException;

    void deleteById(int id) throws DAOException, ConnectException;

    Driver getById(int id) throws DAOException, ConnectException;

    List<Driver> getAll() throws ConnectException;
}

