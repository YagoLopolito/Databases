package com.solvd.Uver.service;


import com.solvd.Uver.entities.SuperCar;
import com.solvd.Uver.exception.DAOException;

import java.util.List;

public interface SuperCarService {
    void give(SuperCar a) throws DAOException;

    void delete(int id) throws DAOException;

    void modify(SuperCar entities) throws DAOException;

    SuperCar getOne(int id) throws DAOException;

    List<SuperCar> getAll() throws DAOException;
}
