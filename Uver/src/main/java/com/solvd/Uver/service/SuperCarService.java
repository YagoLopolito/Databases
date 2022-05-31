package com.solvd.Uver.service;


import com.solvd.Uver.entities.SuperCar;

import java.util.List;

public interface SuperCarService {
    void give(SuperCar a);

    void delete(int id);

    void modify(SuperCar entities);

    SuperCar getOne(int id);

    List<SuperCar> getAll();
}
