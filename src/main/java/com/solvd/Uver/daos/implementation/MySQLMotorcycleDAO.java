package com.solvd.Uver.daos.implementation;

import com.solvd.Uver.daos.MotorcycleDAO;
import com.solvd.Uver.entities.Moto;
import com.solvd.Uver.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLMotorcycleDAO implements MotorcycleDAO {
    private final static String INSERT = "INSERT INTO motorcycle(idMotorcycle, make, model, maxSpeed) VALUES(?, ?, ?, ?)";
    private final static String UPDATE = "UPDATE motorcycle SET idMotorcycle = ?, make = ?, model = ?, maxSpeed = ? WHERE idMotorcycle = ?";
    private final static String DELETE = "DELETE FROM motorcycle WHERE idMotorcycle = ?";
    private final static String GET_ALL = "SELECT idMotorcycle, make, model, maxSpeed FROM motorcycle";
    private final static String GET_ONE = "SELECT idMotorcycle, make, model, maxSpeed FROM motorcycle WHERE idMotorcycle = ?";
    private final Connection conn;

    public MySQLMotorcycleDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Moto a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setInt(1, a.getIdCar());
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
    public void modify(Moto a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setInt(1, a.getIdCar());
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


    private Moto convert(ResultSet rs) throws SQLException {
        String make = rs.getString("make");
        String model = rs.getString("model");
        Integer maxSpeed = rs.getInt("maxSpeed");
        Moto moto = new Moto(make, model, maxSpeed);
        moto.setIdCar(rs.getInt("idCar"));
        return moto;
    }

    @Override
    public List<Moto> giveAll() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Moto> motos = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GET_ALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                motos.add(convert(rs));
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
        return motos;
    }

    @Override
    public Moto give(Integer id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Moto a = null;
        try {
            stat = conn.prepareStatement(GET_ONE);
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

