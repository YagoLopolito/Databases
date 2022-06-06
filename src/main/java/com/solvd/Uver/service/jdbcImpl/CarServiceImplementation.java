package com.solvd.Uver.service.jdbcImpl;

import com.solvd.Uver.daos.CarDAO;
import com.solvd.Uver.daos.DAOimpl.CarDAOImpl;
import com.solvd.Uver.entities.Car;
import com.solvd.Uver.exception.DAOException;
import com.solvd.Uver.service.CarService;

import java.net.ConnectException;
import java.util.List;

public class CarServiceImplementation implements CarService {


    @Override
    public void insert(Car a) {
        CarDAO cars = new CarDAOImpl();
        try {
            cars.insert(a);
        } catch (DAOException | ConnectException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Car a) throws ConnectException {
        CarDAO cars = new CarDAOImpl();
        try {
            cars.update(a);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void deleteById(int id) throws ConnectException {
        CarDAO cars = new CarDAOImpl();
        try {
            cars.deleteById(id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Car getById(int id) throws ConnectException {
        CarDAO cars = new CarDAOImpl();
        Car car = null;
        try {
            car = cars.getById(id);

        } catch (DAOException e) {
            e.printStackTrace();
        }
        return car;
    }

    @Override
    public List<Car> getAll() throws ConnectException {
        CarDAO cars = new CarDAOImpl();
        List<Car> carList = null;
        try {
            carList = cars.getAll();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return carList;
    }
}
