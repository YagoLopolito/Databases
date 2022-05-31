package com.solvd.Uver.service;

import com.solvd.Uver.entities.Employee;
import com.solvd.Uver.exception.DAOException;

import java.util.List;

public interface EmployeeService {

    void give(Employee a) throws DAOException;

    void delete(int id) throws DAOException;

    void modify(Employee entities) throws DAOException;

    Employee getOne(int id) throws DAOException;

    List<Employee> getAll() throws DAOException;

}
