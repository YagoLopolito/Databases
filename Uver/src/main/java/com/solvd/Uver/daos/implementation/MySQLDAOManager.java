package com.solvd.Uver.daos.implementation;

import com.solvd.Uver.daos.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDAOManager implements DAOManager {

    private final Connection conn;

    private CarDAO cars = null;
    private DriverDAO drivers = null;
    private MotorcycleDAO motorcycles = null;
    private SuperCarDAO superCars = null;
    private SuperMotoDAO superMotos = null;


    public MySQLDAOManager(String username, String password, String database) throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://52.59.193.212:3306/yago_lopolito", "root", "devintern");
    }

    @Override
    public CarDAO getCarDAO() {
        if (cars == null) {
            cars = new MySQLCarDAO(conn);
        }
        return cars;
    }





    @Override
    public DriverDAO getDriverDAO() {
        if (drivers == null) {
            drivers = new MySQLDriverDAO(conn);
        }
        return drivers;
    }



    @Override
    public MotorcycleDAO getMotorcycleDAO() {
        if (motorcycles == null) {
            motorcycles = new MySQLMotorcycleDAO(conn);
        }
        return motorcycles;
    }


    @Override
    public SuperCarDAO getSuperCarDAO() {
        if (superCars == null) {
            superCars = new MySQLSuperCarDAO(conn);
        }
        return superCars;
    }

    @Override
    public SuperMotoDAO getSuperMotoDAO() {
        if (superMotos == null) {
            superMotos = new MySQLSuperMotoDAO(conn);
        }
        return superMotos;
    }
}
