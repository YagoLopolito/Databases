package com.solvd.Uver.service;

import com.solvd.Uver.entities.Driver;
import com.solvd.Uver.exception.DAOException;

import java.util.List;

public interface DriverService {
    void give(Driver a) throws DAOException;

    void modify(Driver entities) throws DAOException;

    void delete(int id) throws DAOException;

    Driver getOne(int id) throws DAOException;

    List<Driver> getAll();
}
