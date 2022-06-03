package com.solvd.Uver.service.implementation;

import com.solvd.Uver.daos.MotorcycleDAO;
import com.solvd.Uver.daos.implementation.MySQLMotorcycleDAO;
import com.solvd.Uver.entities.Moto;
import com.solvd.Uver.exception.DAOException;
import com.solvd.Uver.service.MotorcycleService;

import java.sql.Connection;
import java.util.List;

public class MotorcycleServiceImplementation implements MotorcycleService {
    private final Connection conn;

    public MotorcycleServiceImplementation(Connection conn) {
        this.conn = conn;
    }


    @Override
    public void give(Moto a) throws DAOException {
        MotorcycleDAO moto = new MySQLMotorcycleDAO(conn);
        moto.insert(a);
    }

    @Override
    public void delete(int a) throws DAOException {
        MotorcycleDAO moto = new MySQLMotorcycleDAO(conn);
        moto.delete(a);
    }

    @Override
    public void modify(Moto a) throws DAOException {
        MotorcycleDAO moto = new MySQLMotorcycleDAO(conn);
        moto.modify(a);
    }

    @Override
    public Moto getOne(int id) throws DAOException {
        MotorcycleDAO moto = new MySQLMotorcycleDAO(conn);
        Moto motorcycle = null;
        motorcycle = moto.give(id);
        return motorcycle;
    }

    @Override
    public List<Moto> getAll() throws DAOException {
        MotorcycleDAO moto = new MySQLMotorcycleDAO(conn);
        List<Moto> motoList = null;
        motoList = moto.giveAll();
        return motoList;
    }

}
