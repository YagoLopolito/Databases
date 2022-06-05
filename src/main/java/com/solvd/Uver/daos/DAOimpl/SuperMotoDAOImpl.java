package com.solvd.Uver.daos.DAOimpl;

import com.solvd.Uver.daos.SuperMotoDAO;
import com.solvd.Uver.entities.SuperMotorcycle;
import com.solvd.Uver.exception.DAOException;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SuperMotoDAOImpl extends AbstractJDBCDao implements SuperMotoDAO {
    private final static String INSERT = "INSERT INTO superMotorcycle(idSuperMotorcycle, make, model, maxSpeed) VALUES(?, ?, ?, ?)";
    private final static String UPDATE = "UPDATE superMotorcycle SET make = ?, model = ?, maxSpeed = ? WHERE idSuperMotorcycle = ?";
    private final static String DELETE = "DELETE FROM superMotorcycle WHERE idSuperMotorcycle = ?";
    private final static String GET_ALL = "SELECT idSuperMotorcycle, make, model, maxSpeed FROM superMotorcycle";
    private final static String GET_ONE = "SELECT idSuperMotorcycle, make, model, maxSpeed FROM superMotorcycle WHERE idSuperMotorcycle = ?";

    @Override
    public void insert(SuperMotorcycle a) throws DAOException, ConnectException {
        PreparedStatement stat = null;
        Connection conn = getConnection();
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
            returnConnection(conn);
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
    public void deleteById(int id) throws DAOException, ConnectException {
        PreparedStatement stat = null;
        Connection conn = getConnection();
        try {
            stat = conn.prepareStatement(DELETE);
            stat.setInt(1, id);
            if (stat.executeUpdate() == 0) {
                throw new DAOException("May not have been saved");
            }

        } catch (SQLException e) {
            throw new DAOException("Error in SQL", e);
        } finally {
            returnConnection(conn);
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
    public void update(SuperMotorcycle a) throws DAOException, ConnectException {
        PreparedStatement stat = null;
        Connection conn = getConnection();
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setString(1, a.getMake());
            stat.setString(2, a.getModel());
            stat.setInt(3, a.getMaxSpeed());
            stat.setInt(4, a.getIdSuperMotorcycle());
            if (stat.executeUpdate() == 0) {
                throw new DAOException("May not have been saved");
            }

        } catch (SQLException e) {
            throw new DAOException("Error in SQL", e);
        } finally {
            returnConnection(conn);
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
    public List<SuperMotorcycle> getAll() throws DAOException, ConnectException {
        PreparedStatement stat = null;
        Connection conn = getConnection();
        ResultSet rs = null;
        List<SuperMotorcycle> sMotos = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GET_ALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                sMotos.add(convert(rs));
            }
        } catch (SQLException e) {
            throw new DAOException("SQL Erorr", e);
        } finally {
            returnConnection(conn);
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
    public SuperMotorcycle getById(int id) throws DAOException, ConnectException {
        PreparedStatement stat = null;
        Connection conn = getConnection();
        ResultSet rs = null;
        SuperMotorcycle a;
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
            returnConnection(conn);
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
