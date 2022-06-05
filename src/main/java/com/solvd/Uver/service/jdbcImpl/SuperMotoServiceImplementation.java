package com.solvd.Uver.service.jdbcImpl;

import com.solvd.Uver.daos.SuperMotoDAO;
import com.solvd.Uver.daos.DAOimpl.SuperMotoDAOImpl;
import com.solvd.Uver.entities.SuperMotorcycle;
import com.solvd.Uver.exception.DAOException;
import com.solvd.Uver.service.daoServices.SuperMotoService;

import java.net.ConnectException;
import java.util.List;

public class SuperMotoServiceImplementation implements SuperMotoService {

    @Override
    public void insert(SuperMotorcycle a) throws DAOException, ConnectException {
        SuperMotoDAO sMoto = new SuperMotoDAOImpl();
        sMoto.insert(a);
    }

    @Override
    public void deleteById(int id) throws DAOException, ConnectException {
        SuperMotoDAO sMoto = new SuperMotoDAOImpl();
        sMoto.deleteById(id);
    }

    @Override
    public void update(SuperMotorcycle a) throws DAOException, ConnectException {
        SuperMotoDAO sMoto = new SuperMotoDAOImpl();
        sMoto.update(a);
    }

    @Override
    public SuperMotorcycle getById(int id) throws DAOException, ConnectException {
        SuperMotoDAO sMoto = new SuperMotoDAOImpl();
        SuperMotorcycle superMoto;
        superMoto = sMoto.getById(id);
        return superMoto;
    }

    @Override
    public List<SuperMotorcycle> getAll() throws DAOException, ConnectException {
        SuperMotoDAO sMoto = new SuperMotoDAOImpl();
        List<SuperMotorcycle> superMotorcycleList;
        superMotorcycleList = sMoto.getAll();
        return superMotorcycleList;
    }
}
