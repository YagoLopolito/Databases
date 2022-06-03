package com.solvd.Uver.service.implementation;

import com.solvd.Uver.daos.SuperCarDAO;
import com.solvd.Uver.daos.implementation.MySQLSuperCarDAO;
import com.solvd.Uver.entities.SuperCar;
import com.solvd.Uver.exception.DAOException;
import com.solvd.Uver.service.SuperCarService;

import java.sql.Connection;
import java.util.List;

public class SuperCarServiceImplementation implements SuperCarService {
    private Connection conn;

    public SuperCarServiceImplementation(Connection conn) {
        this.conn = conn;
    }


    @Override
    public void give(SuperCar a) throws DAOException {
        SuperCarDAO sCar = new MySQLSuperCarDAO(conn);
        sCar.insert(a);
    }

    @Override
    public void delete(int id) throws DAOException {
        SuperCarDAO sCar = new MySQLSuperCarDAO(conn);
        sCar.delete(id);
    }

    @Override
    public void modify(SuperCar entities) throws DAOException {
        SuperCarDAO sCar = new MySQLSuperCarDAO(conn);
        sCar.modify(entities);
    }

    @Override
    public SuperCar getOne(int id) throws DAOException {
        SuperCarDAO sCar = new MySQLSuperCarDAO(conn);
        SuperCar superCar = null;
        superCar = sCar.give(id);
        return superCar;
    }

    @Override
    public List<SuperCar> getAll() throws DAOException {
        SuperCarDAO sCar = new MySQLSuperCarDAO(conn);
        List<SuperCar> sCarList = null;
        sCarList = sCar.giveAll();
        return sCarList;

    }
}
