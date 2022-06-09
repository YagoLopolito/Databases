package com.solvd.Uver.service;


import com.solvd.Uver.entities.Car;

import java.net.ConnectException;
import java.util.List;

public interface CarService {
    void insert(Car a) throws ConnectException;

    void update(Car a) throws ConnectException;

    void deleteById(int id) throws ConnectException;

    Car getById(int id) throws ConnectException;

    List<Car> getAll() throws ConnectException;

}
