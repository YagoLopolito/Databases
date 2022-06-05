package com.solvd.Uver.service;

import com.solvd.Uver.entities.Moto;
import com.solvd.Uver.exception.DAOException;

import java.net.ConnectException;
import java.util.List;

public interface MotorcycleService {

    void insert(Moto a) throws DAOException, ConnectException;

    void deleteById(int id) throws DAOException, ConnectException;

    void update(Moto a) throws DAOException, ConnectException;

    Moto getById(int id) throws DAOException, ConnectException;

    List<Moto> getAll() throws DAOException, ConnectException;

}
