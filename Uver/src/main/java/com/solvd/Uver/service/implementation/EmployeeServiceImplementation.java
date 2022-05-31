package com.solvd.Uver.service.implementation;

import com.solvd.Uver.daos.EmployeeDAO;
import com.solvd.Uver.daos.implementation.MySQLEmployeeDAO;
import com.solvd.Uver.entities.Employee;
import com.solvd.Uver.exception.DAOException;
import com.solvd.Uver.service.EmployeeService;

import java.sql.Connection;
import java.util.List;

public class EmployeeServiceImplementation implements EmployeeService {
    private final Connection conn;

    public EmployeeServiceImplementation(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void give(Employee a) throws DAOException {
        EmployeeDAO emp = new MySQLEmployeeDAO(conn);
        emp.insert(a);
    }

    @Override
    public void delete(int a) throws DAOException {
        EmployeeDAO emp = new MySQLEmployeeDAO(conn);
        emp.delete(a);
    }

    @Override
    public void modify(Employee a) throws DAOException {
        EmployeeDAO emp = new MySQLEmployeeDAO(conn);
        emp.modify(a);
    }

    @Override
    public Employee getOne(int id) throws DAOException {
        EmployeeDAO emp = new MySQLEmployeeDAO(conn);
        Employee employee = null;
        employee = emp.give(id);
        return employee;
    }

    @Override
    public List<Employee> getAll() throws DAOException {
        EmployeeDAO emp = new MySQLEmployeeDAO(conn);
        List<Employee> employeeList = null;
        employeeList = emp.giveAll();
        return employeeList;
    }

}
