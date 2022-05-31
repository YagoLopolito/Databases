package com.solvd.Uver.daos.implementation;

import com.solvd.Uver.daos.DriverDAO;
import com.solvd.Uver.entities.Driver;
import com.solvd.Uver.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLDriverDAO implements DriverDAO {
    final String INSERT = "INSERT INTO driver(idDriver, firstName, lastName, wage) VALUES(?, ?, ?, ?)";
    final String UPDATE = "UPDATE driver SET idCar = ?, firstName = ?, lastName = ?, wage = ? WHERE idDriver = ?";
    final String DELETE = "DELETE FROM driver WHERE idDriver = ?";
    final String GETALL = "SELECT idDriver, firstName, lastName, wage FROM driver";
    final String GETONE = "SELECT idDriver, firstName, lastName, wage FROM driver WHERE idDriver = ?";
    private final Connection conn;

    public MySQLDriverDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Driver a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setInt(1, a.getIdDriver());
            stat.setString(2, a.getFirstName());
            stat.setString(3, a.getLastName());
            stat.setInt(4, a.getWage());

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
    public void modify(Driver a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setInt(1, a.getIdDriver());
            stat.setString(2, a.getFirstName());
            stat.setString(3, a.getLastName());
            stat.setInt(4, a.getWage());

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


    private Driver convert(ResultSet rs) throws SQLException {
        String firstName = rs.getString("firstName");
        String lastName = rs.getString("lastName");
        Integer wage = rs.getInt("wage");
        Driver driver = new Driver(firstName, lastName, wage);
        driver.setIdDriver(rs.getInt("idDriver"));
        return driver;
    }

    @Override
    public List<Driver> giveAll() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Driver> drivers = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                drivers.add(convert(rs));
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
        return drivers;
    }

    @Override
    public Driver give(Integer id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Driver a = null;
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
