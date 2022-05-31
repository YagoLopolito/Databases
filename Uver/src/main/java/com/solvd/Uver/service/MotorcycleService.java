package com.solvd.Uver.service;

import com.solvd.Uver.entities.Moto;
import com.solvd.Uver.exception.DAOException;

import java.util.List;

public interface MotorcycleService {

    void give(Moto a) throws DAOException;

    void delete(int id) throws DAOException;

    void modify(Moto entities) throws DAOException;

    Moto getOne(int id) throws DAOException;

    List<Moto> getAll() throws DAOException;

}
