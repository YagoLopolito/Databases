package com.solvd.Uver.daos.implementation;

import com.solvd.Uver.daos.EmployeeDAO;
import com.solvd.Uver.entities.Employee;
import com.solvd.Uver.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLEmployeeDAO implements EmployeeDAO {
    final String INSERT = "INSERT INTO employee(idEmployee, firstName, lastName, position, wage) VALUES(?, ?, ?, ?, ?)";
    final String UPDATE = "UPDATE employee SET idCar = ?, firstName = ?, lastName = ?, position = ?, wage = ? WHERE idEmployee = ?";
    final String DELETE = "DELETE FROM employee WHERE idEmployee = ?";
    final String GETALL = "SELECT idEmployee, firstName, lastName, position, wage FROM employee";
    final String GETONE = "SELECT idEmployee, firstName, lastName, position, wage FROM employee WHERE idEmployee = ?";
    private final Connection conn;

    public MySQLEmployeeDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Employee a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setInt(1, a.getIdEmployees());
            stat.setString(2, a.getFirstName());
            stat.setString(3, a.getLastName());
            stat.setString(4, a.getPosition());
            stat.setInt(5, a.getWage());

            if (stat.executeUpdate() == 0) {
                throw new DAOException("May not have been saved");
            }

        } catch (SQLException e) {
            throw new DAOException("Error in SQL", e);
        } finally {

            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new DAOException("Error in SQL", e);
                }
            }
        }
    }

    @Override
    public void delete(int a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(DELETE);
            stat.setInt(1, a);

            if (stat.executeUpdate() == 0) {
                throw new DAOException("May not have been saved");
            }

        } catch (SQLException e) {
            throw new DAOException("Error in SQL", e);
        } finally {

            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new DAOException("Error in SQL", e);
                }
            }
        }
    }

    @Override
    public void modify(Employee a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setInt(1, a.getIdEmployees());
            stat.setString(2, a.getFirstName());
            stat.setString(3, a.getLastName());
            stat.setString(4, a.getPosition());
            stat.setInt(5, a.getWage());

            if (stat.executeUpdate() == 0) {
                throw new DAOException("May not have been saved");
            }

        } catch (SQLException e) {
            throw new DAOException("Error in SQL", e);
        } finally {

            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new DAOException("Error in SQL", e);
                }
            }
        }
    }

    private Employee convert(ResultSet rs) throws SQLException {
        String firstName = rs.getString("firstName");
        String lastName = rs.getString("lastName");
        String position = rs.getString("position");
        Integer wage = rs.getInt("wage");
        Employee employee = new Employee(firstName, lastName, position, wage);
        employee.setIdEmployees(rs.getInt("idEmployee"));
        return employee;
    }

    @Override
    public List<Employee> giveAll() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Employee> employees = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                employees.add(convert(rs));
            }
        } catch (SQLException e) {
            throw new DAOException("SQL Erorr", e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    new DAOException("SQL ERROR.", e);
                }
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    new DAOException("SQL ERROR.", e);
                }
            }

        }
        return employees;
    }

    @Override
    public Employee give(Integer id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Employee a = null;
        try {
            stat = conn.prepareStatement(GETONE);
            stat.setInt(1, id);
            rs = stat.executeQuery();

            if (rs.next()) {
                a = convert(rs);
            } else {
                throw new DAOException("The register doesn´t found.");
            }
        } catch (SQLException e) {
            throw new DAOException("SQL Erorr", e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    new DAOException("SQL ERROR.", e);
                }
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    new DAOException("SQL ERROR.", e);
                }
            }

        }
        return a;
    }
}
