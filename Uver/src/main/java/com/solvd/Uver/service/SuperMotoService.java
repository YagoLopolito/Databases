package com.solvd.Uver.service;

import com.solvd.Uver.entities.SuperMotorcycle;

import java.util.List;

public interface SuperMotoService {

    void give(SuperMotorcycle a);

    void delete(int id);

    void modify(SuperMotorcycle entities);

    SuperMotorcycle getOne(int id);

    List<SuperMotorcycle> getAll();

}
