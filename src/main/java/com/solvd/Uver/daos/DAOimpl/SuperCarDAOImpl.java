package com.solvd.Uver.daos.DAOimpl;

import com.solvd.Uver.daos.SuperCarDAO;
import com.solvd.Uver.entities.SuperCar;
import com.solvd.Uver.entities.SuperMotorcycle;
import com.solvd.Uver.exception.DAOException;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SuperCarDAOImpl extends AbstractJDBCDao implements SuperCarDAO {
    private final static String INSERT = "INSERT INTO supercar(idSuperCar, make, model, maxSpeed) VALUES(?, ?, ?, ?)";
    private final static String UPDATE = "UPDATE supercar SET make = ?, model = ?, maxSpeed = ? WHERE idSuperCar = ?";
    private final static String DELETE = "DELETE FROM superCar WHERE idSuperCar = ?";
    private final static String GET_ALL = "SELECT idSuperCar, make, model, maxSpeed FROM supercar";
    private final static String GET_ONE = "SELECT idSuperCar, make, model, maxSpeed FROM supercar WHERE idSuperCar = ?";

    @Override
    public void insert(SuperCar a) throws DAOException, ConnectException {
        PreparedStatement stat = null;
        Connection conn = getConnection();
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setString(1, a.getMake());
            stat.setString(2, a.getModel());
            stat.setInt(3, a.getMaxSpeed());
            stat.setInt(4, a.getIdSuperCar());

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
    public void update(SuperCar a) throws DAOException, ConnectException {
        PreparedStatement stat = null;
        Connection conn = getConnection();
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setString(1, a.getMake());
            stat.setString(2, a.getModel());
            stat.setInt(3, a.getMaxSpeed());
            stat.setInt(4, a.getIdSuperCar());

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


    private SuperCar convert(ResultSet rs) throws SQLException {
        String make = rs.getString("make");
        String model = rs.getString("model");
        Integer maxSpeed = rs.getInt("maxSpeed");
        SuperCar sCar = new SuperCar(make, model, maxSpeed);
        sCar.setIdSuperCar(rs.getInt("idSuperCar"));
        return sCar;
    }

    @Override
    public List<SuperCar> getAll() throws DAOException, ConnectException {
        PreparedStatement stat = null;
        Connection conn = getConnection();
        ResultSet rs = null;
        List<SuperCar> sCars = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GET_ALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                sCars.add(convert(rs));
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
        return sCars;
    }

    @Override
    public SuperCar getById(int id) throws DAOException, ConnectException {
        PreparedStatement stat = null;
        Connection conn = getConnection();
        ResultSet rs = null;
        SuperCar a;
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
