package com.solvd.Uver.service.jdbcImpl;

import com.solvd.Uver.daos.SuperCarDAO;
import com.solvd.Uver.daos.DAOimpl.SuperCarDAOImpl;
import com.solvd.Uver.entities.SuperCar;
import com.solvd.Uver.exception.DAOException;
import com.solvd.Uver.service.daoServices.SuperCarService;

import java.net.ConnectException;
import java.util.List;

public class SuperCarServiceImplementation implements SuperCarService {

    @Override
    public void insert(SuperCar a) throws DAOException, ConnectException {
        SuperCarDAO sCar = new SuperCarDAOImpl();
        sCar.insert(a);
    }

    @Override
    public void deleteById(int id) throws DAOException, ConnectException {
        SuperCarDAO sCar = new SuperCarDAOImpl();
        sCar.deleteById(id);
    }

    @Override
    public void update(SuperCar a) throws DAOException, ConnectException {
        SuperCarDAO sCar = new SuperCarDAOImpl();
        sCar.update(a);
    }

    @Override
    public SuperCar getById(int id) throws DAOException, ConnectException {
        SuperCarDAO sCar = new SuperCarDAOImpl();
        SuperCar superCar;
        superCar = sCar.getById(id);
        return superCar;
    }

    @Override
    public List<SuperCar> getAll() throws DAOException, ConnectException {
        SuperCarDAO sCar = new SuperCarDAOImpl();
        List<SuperCar> sCarList;
        sCarList = sCar.getAll();
        return sCarList;

    }
}
