package com.solvd.Uver.daos.implementation;

import com.solvd.Uver.daos.SuperMotoDAO;
import com.solvd.Uver.entities.SuperMotorcycle;
import com.solvd.Uver.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLSuperMotoDAO implements SuperMotoDAO {
    final String INSERT = "INSERT INTO superMotorcycle(idSuperMotorcycle, make, model, maxSpeed) VALUES(?, ?, ?, ?)";
    final String UPDATE = "UPDATE superMotorcycle SET idSuperMotorcycle = ?, make = ?, model = ?, maxSpeed = ? WHERE idSuperMotorcycle = ?";
    final String DELETE = "DELETE FROM superMotorcycle WHERE idSuperMotorcycle = ?";
    final String GETALL = "SELECT idSuperMotorcycle, make, model, maxSpeed FROM superMotorcycle";
    final String GETONE = "SELECT idSuperMotorcycle, make, model, maxSpeed FROM superMotorcycle WHERE idSuperMotorcycle = ?";
    private final Connection conn;

    public MySQLSuperMotoDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(SuperMotorcycle a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setInt(1, a.getIdSuperMotorcycle());
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
    public void modify(SuperMotorcycle a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setInt(1, a.getIdSuperMotorcycle());
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

    private SuperMotorcycle convert(ResultSet rs) throws SQLException {
        String make = rs.getString("make");
        String model = rs.getString("model");
        Integer maxSpeed = rs.getInt("maxSpeed");
        SuperMotorcycle sMoto = new SuperMotorcycle(make, model, maxSpeed);
        sMoto.setIdSuperMotorcycle(rs.getInt("idCar"));
        return sMoto;
    }

    @Override
    public List<SuperMotorcycle> giveAll() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<SuperMotorcycle> sMotos = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                sMotos.add(convert(rs));
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
        return sMotos;
    }

    @Override
    public SuperMotorcycle give(Integer id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        SuperMotorcycle a = null;
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
