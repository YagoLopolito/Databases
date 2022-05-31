package com.solvd.Uver.service;

import com.solvd.Uver.entities.SuperMotorcycle;
import com.solvd.Uver.exception.DAOException;

import java.util.List;

public interface SuperMotoService {

    void give(SuperMotorcycle a) throws DAOException;

    void delete(int id) throws DAOException;

    void modify(SuperMotorcycle entities) throws DAOException;

    SuperMotorcycle getOne(int id) throws DAOException;

    List<SuperMotorcycle> getAll() throws DAOException;

}
