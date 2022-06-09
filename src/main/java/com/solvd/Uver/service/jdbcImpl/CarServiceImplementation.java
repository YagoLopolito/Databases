package com.solvd.Uver.service.jdbcImpl;

import com.solvd.Uver.daos.CarDAO;
import com.solvd.Uver.daos.DAOimpl.CarDAOImpl;
import com.solvd.Uver.entities.Car;
import com.solvd.Uver.exception.DAOException;
import com.solvd.Uver.service.CarService;
import org.apache.ibatis.session.SqlSession;

import java.net.ConnectException;
import java.util.List;

public class CarServiceImplementation implements CarService {


    @Override
    public void insert(Car a) throws ConnectException {
        CarDAO cars = new CarDAOImpl();
            cars.insert(a);
    }

    @Override
    public void update(Car a) throws ConnectException {
        CarDAO cars = new CarDAOImpl();
            cars.update(a);
    }


    @Override
    public void deleteById(int id) throws ConnectException {
        CarDAO cars = new CarDAOImpl();
            cars.deleteById(id);
    }

    @Override
    public Car getById(int id) throws ConnectException {
        CarDAO cars = new CarDAOImpl();
        Car car = null;
        car = cars.getById(id);

        return car;
    }

    @Override
    public List<Car> getAll() throws ConnectException {
        CarDAO cars = new CarDAOImpl();
        List<Car> carList;
        carList = cars.getAll();

        return carList;
    }
}
