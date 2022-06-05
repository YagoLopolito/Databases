package com.solvd.Uver.PAPA;

import com.solvd.Uver.entities.Employee;
import com.solvd.Uver.exception.DAOException;

import java.net.ConnectException;

public class CRUD<T extends Employee> {
    void create(T t) throws DAOException, ConnectException {
        t.insert();
    }
    T read(){

        return null;
    }

    void update(T t){

    }
    void delete(T t){

    }



}
