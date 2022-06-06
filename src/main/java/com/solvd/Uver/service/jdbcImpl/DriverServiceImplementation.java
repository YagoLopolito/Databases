package com.solvd.Uver.service.jdbcImpl;

import com.solvd.Uver.daos.DriverDAO;
import com.solvd.Uver.daos.DAOimpl.DriverDAOImpl;
import com.solvd.Uver.entities.Driver;
import com.solvd.Uver.exception.DAOException;
import com.solvd.Uver.service.DriverService;

import java.net.ConnectException;
import java.util.List;


public class DriverServiceImplementation implements DriverService {

    @Override
    public void deleteById(int id) throws DAOException, ConnectException {
        DriverDAO driver = new DriverDAOImpl();
        driver.deleteById(id);
    }

    @Override
    public Driver getById(int id) throws DAOException, ConnectException {
        DriverDAO drivers = new DriverDAOImpl();
        Driver driver = null;
        driver = drivers.getById(id);
        return driver;
    }

    @Override
    public List<Driver> getAll() {
        DriverDAO driver = new DriverDAOImpl();
        List<Driver> driverList = null;
        try {
            driverList = driver.getAll();
        } catch (DAOException | ConnectException e) {
            e.printStackTrace();
        }
        return driverList;
    }


    @Override
    public void insert(Driver a) throws DAOException, ConnectException {
        DriverDAO driver = new DriverDAOImpl();
        driver.insert(a);
    }

    @Override
    public void update(Driver a) throws DAOException, ConnectException {
        DriverDAO driver = new DriverDAOImpl();
        driver.update(a);
    }


}
