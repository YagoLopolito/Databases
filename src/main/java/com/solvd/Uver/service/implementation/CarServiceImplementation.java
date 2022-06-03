package com.solvd.Uver.service.implementation;

import com.solvd.Uver.daos.CarDAO;
import com.solvd.Uver.daos.implementation.MySQLCarDAO;
import com.solvd.Uver.entities.Car;
import com.solvd.Uver.exception.DAOException;
import com.solvd.Uver.service.CarService;

import java.sql.Connection;
import java.util.List;

public class CarServiceImplementation implements CarService {
    private final Connection conn;

    public CarServiceImplementation(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void give(Car a) {
        CarDAO cars = new MySQLCarDAO(conn);
        try {
            cars.insert(a);
        } catch (DAOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void modify(Car entities) {
        CarDAO cars = new MySQLCarDAO(conn);
        try {
            cars.modify(entities);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(int id) {
        CarDAO cars = new MySQLCarDAO(conn);
        try {
            cars.delete(id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Car getOne(int id) {
        CarDAO cars = new MySQLCarDAO(conn);
        Car car = null;
        try {
            car = cars.give(id);

        } catch (DAOException e) {
            e.printStackTrace();
        }
        return car;
    }

    @Override
    public List<Car> getAll() {
        CarDAO cars = new MySQLCarDAO(conn);
        List<Car> carList = null;
        try {
            carList = cars.giveAll();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return carList;
    }
}
