package com.solvd.Uver.service.implementation;

import com.solvd.Uver.daos.DriverDAO;
import com.solvd.Uver.daos.implementation.MySQLDriverDAO;
import com.solvd.Uver.entities.Driver;
import com.solvd.Uver.exception.DAOException;
import com.solvd.Uver.service.DriverService;

import java.sql.Connection;
import java.util.List;

public class DriverServiceImplementation implements DriverService {
    private final Connection conn;

    public DriverServiceImplementation(Connection conn) {
        this.conn = conn;
    }


    @Override
    public void delete(int a) throws DAOException {
        DriverDAO driver = new MySQLDriverDAO(conn);
        driver.delete(a);
    }

    @Override
    public Driver getOne(int id) throws DAOException {
        DriverDAO drivers = new MySQLDriverDAO(conn);
        Driver driver = null;
        driver = drivers.give(id);
        return driver;
    }

    @Override
    public List<Driver> getAll() {
        DriverDAO driver = new MySQLDriverDAO(conn);
        List<Driver> driverList = null;
        try {
            driverList = driver.giveAll();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return driverList;
    }

    @Override
    public void give(Driver a) throws DAOException {
        DriverDAO driver = new MySQLDriverDAO(conn);
        driver.insert(a);
    }

    @Override
    public void modify(Driver a) throws DAOException {
        DriverDAO driver = new MySQLDriverDAO(conn);
        driver.modify(a);
    }


}
