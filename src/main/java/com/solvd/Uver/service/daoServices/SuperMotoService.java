package com.solvd.Uver.service.daoServices;

import com.solvd.Uver.entities.SuperMotorcycle;
import com.solvd.Uver.exception.DAOException;

import java.net.ConnectException;
import java.util.List;

public interface SuperMotoService {

    void insert(SuperMotorcycle a) throws DAOException, ConnectException;

    void deleteById(int id) throws DAOException, ConnectException;

    void update(SuperMotorcycle a) throws DAOException, ConnectException;

    SuperMotorcycle getById(int id) throws DAOException, ConnectException;

    List<SuperMotorcycle> getAll() throws DAOException, ConnectException;

}
