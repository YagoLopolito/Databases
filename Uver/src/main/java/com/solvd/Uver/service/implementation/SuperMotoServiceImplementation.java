package com.solvd.Uver.service.implementation;

import com.solvd.Uver.daos.SuperCarDAO;
import com.solvd.Uver.daos.SuperMotoDAO;
import com.solvd.Uver.daos.implementation.MySQLSuperCarDAO;
import com.solvd.Uver.daos.implementation.MySQLSuperMotoDAO;
import com.solvd.Uver.entities.SuperCar;
import com.solvd.Uver.entities.SuperMotorcycle;
import com.solvd.Uver.exception.DAOException;
import com.solvd.Uver.service.SuperMotoService;

import java.sql.Connection;
import java.util.List;

public class SuperMotoServiceImplementation implements SuperMotoService {
    private Connection conn;

    public SuperMotoServiceImplementation(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void give(SuperMotorcycle a) throws DAOException {
        SuperMotoDAO sMoto = new MySQLSuperMotoDAO(conn);
        sMoto.insert(a);
    }

    @Override
    public void delete(int id) throws DAOException {
        SuperMotoDAO sMoto = new MySQLSuperMotoDAO(conn);
        sMoto.delete(id);
    }

    @Override
    public void modify(SuperMotorcycle entities) throws DAOException {
        SuperMotoDAO sMoto = new MySQLSuperMotoDAO(conn);
        sMoto.modify(entities);
    }

    @Override
    public SuperMotorcycle getOne(int id) throws DAOException {
        SuperMotoDAO sMoto = new MySQLSuperMotoDAO(conn);
        SuperMotorcycle superMoto = null;
        superMoto = sMoto.give(id);
        return superMoto;
    }

    @Override
    public List<SuperMotorcycle> getAll() throws DAOException {
        SuperMotoDAO sMoto = new MySQLSuperMotoDAO(conn);
        List<SuperMotorcycle> superMotorcycleList = null;
        superMotorcycleList = sMoto.giveAll();
        return superMotorcycleList;
    }
}
