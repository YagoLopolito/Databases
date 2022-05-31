package com.solvd.Uver.service.implementation;

import com.solvd.Uver.entities.SuperCar;
import com.solvd.Uver.service.SuperCarService;

import java.sql.Connection;
import java.util.List;

public class SuperCarServiceImplementation implements SuperCarService {
    private Connection conn;

    public OrderServiceImplementation(Connection conn) {
        this.conn = conn;
    }


    @Override
    public void give(SuperCar a) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void modify(SuperCar entities) {

    }

    @Override
    public SuperCar getOne(int id) {
        return null;
    }

    @Override
    public List<SuperCar> getAll() {
        return null;
    }
}
