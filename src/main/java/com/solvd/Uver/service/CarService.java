package com.solvd.Uver.service;


import com.solvd.Uver.entities.Car;

import java.util.List;

public interface CarService {
    void give(Car a);

    void modify(Car entities);

    void delete(int id);

    Car getOne(int id);

    List<Car> getAll();

}
