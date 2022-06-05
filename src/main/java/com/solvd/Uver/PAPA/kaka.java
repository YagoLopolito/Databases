package com.solvd.Uver.PAPA;

import com.solvd.Uver.daos.DAO;
import com.solvd.Uver.entities.Driver;
import com.solvd.Uver.entities.Employee;
import com.solvd.Uver.exception.DAOException;
import com.solvd.Uver.service.jdbcImpl.DriverServiceImplementation;

import java.net.ConnectException;

public class kaka {
    public static void main(String[] args) throws DAOException, ConnectException {
        CRUD<Employee> crud = new CRUD<>();
        DriverServiceImplementation driverServiceImplementation = new DriverServiceImplementation();
        Driver driver1 = new Driver("Carleto", "Suarez", 699);


        System.out.println(driverServiceImplementation.getAll().size()+1);
        System.out.println(driverServiceImplementation.getAll());
    }
}
