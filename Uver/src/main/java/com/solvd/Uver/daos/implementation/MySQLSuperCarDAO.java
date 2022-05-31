package com.solvd.Uver.daos.implementation;

import com.solvd.Uver.daos.SuperCarDAO;
import com.solvd.Uver.entities.SuperCar;
import com.solvd.Uver.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLSuperCarDAO implements SuperCarDAO {
    final String INSERT = "INSERT INTO superCar(idSuperCar, make, model, maxSpeed) VALUES(?, ?, ?, ?)";
    final String UPDATE = "UPDATE superCar SET idSuperCar = ?, make = ?, model = ?, maxSpeed = ? WHERE idSuperCar = ?";
    final String DELETE = "DELETE FROM superCar WHERE idSuperCar = ?";
    final String GETALL = "SELECT idSuperCar, make, model, maxSpeed FROM superCar";
    final String GETONE = "SELECT idSuperCar, make, model, maxSpeed FROM superCar WHERE idSuperCar = ?";
    private final Connection conn;

    public MySQLSuperCarDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(SuperCar a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setInt(1, a.getIdSuperCar());
            stat.setString(2, a.getMake());
            stat.setString(3, a.getModel());
            stat.setInt(4, a.getMaxSpeed());

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
    public void modify(SuperCar a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setInt(1, a.getIdSuperCar());
            stat.setString(2, a.getMake());
            stat.setString(3, a.getModel());
            stat.setInt(4, a.getMaxSpeed());

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


    private SuperCar convert(ResultSet rs) throws SQLException {
        String make = rs.getString("make");
        String model = rs.getString("model");
        Integer maxSpeed = rs.getInt("maxSpeed");
        SuperCar sCar = new SuperCar(make, model, maxSpeed);
        sCar.setIdSuperCar(rs.getInt("idCar"));
        return sCar;
    }

    @Override
    public List<SuperCar> giveAll() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<SuperCar> sCars = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                sCars.add(convert(rs));
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
        return sCars;
    }

    @Override
    public SuperCar give(Integer id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        SuperCar a = null;
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
