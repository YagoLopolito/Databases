package com.solvd.Uver.service.jdbcImpl;

import com.solvd.Uver.daos.MotorcycleDAO;
import com.solvd.Uver.daos.DAOimpl.MotorcycleDAOImpl;
import com.solvd.Uver.entities.Moto;
import com.solvd.Uver.exception.DAOException;
import com.solvd.Uver.service.MotorcycleService;

import java.net.ConnectException;
import java.util.List;

public class MotorcycleServiceImplementation implements MotorcycleService {

    @Override
    public void insert(Moto a) throws DAOException, ConnectException {
        MotorcycleDAO moto = new MotorcycleDAOImpl();
        moto.insert(a);
    }

    @Override
    public void deleteById(int a) throws DAOException, ConnectException {
        MotorcycleDAO moto = new MotorcycleDAOImpl();
        moto.deleteById(a);
    }

    @Override
    public void update(Moto a) throws DAOException, ConnectException {
        MotorcycleDAO moto = new MotorcycleDAOImpl();
        moto.update(a);
    }

    @Override
    public Moto getById(int id) throws DAOException, ConnectException {
        MotorcycleDAO moto = new MotorcycleDAOImpl();
        Moto motorcycle;
        motorcycle = moto.getById(id);
        return motorcycle;
    }

    @Override
    public List<Moto> getAll() throws DAOException, ConnectException {
        MotorcycleDAO moto = new MotorcycleDAOImpl();
        List<Moto> motoList;
        motoList = moto.getAll();
        return motoList;
    }

}
