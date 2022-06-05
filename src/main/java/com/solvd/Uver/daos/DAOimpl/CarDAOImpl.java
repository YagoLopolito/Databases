package com.solvd.Uver.daos.DAOimpl;

import com.solvd.Uver.daos.CarDAO;
import com.solvd.Uver.entities.Car;
import com.solvd.Uver.entities.SuperMotorcycle;
import com.solvd.Uver.exception.DAOException;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAOImpl extends AbstractJDBCDao implements CarDAO {
    private final static String INSERT = "INSERT INTO car(idCar, make, model, maxSpeed) VALUES(?, ?, ?, ?)";
    private final static String UPDATE = "UPDATE car SET make = ?, model = ?, maxSpeed = ? WHERE idCar = ?";
    private final static String DELETE = "DELETE FROM car WHERE idCar = ?";
    private final static String GET_ALL = "SELECT idCar, make, model, maxSpeed FROM car";
    private final static String GET_ONE = "SELECT idCar, make, model, maxSpeed FROM car WHERE idCar = ?";

    @Override
    public void insert(Car a) throws DAOException, ConnectException {
        PreparedStatement stat = null;
        Connection conn = getConnection();
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
            throw new DAOException("SQL ERROR.", e);
        } finally {
            returnConnection(conn);
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new DAOException("SQL ERROR.", e);
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
            throw new DAOException("SQL ERROR.", e);
        } finally {
            returnConnection(conn);
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new DAOException("SQL ERROR.", e);
                }
            }
        }
    }

    @Override
    public void update(Car a) throws DAOException, ConnectException {
        PreparedStatement stat = null;
        Connection conn = getConnection();
        try {
            stat = conn.prepareStatement(UPDATE);

            stat.setString(1, a.getMake());
            stat.setString(2, a.getModel());
            stat.setInt(3, a.getMaxSpeed());
            stat.setInt(4, a.getIdCar());

            if (stat.executeUpdate() == 0) {
                throw new DAOException("May not have been saved");
            }

        } catch (SQLException e) {
            throw new DAOException("SQL ERROR.", e);
        } finally {
            returnConnection(conn);
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new DAOException("SQL ERROR.", e);
                }
            }
        }
    }

    private Car convert(ResultSet rs) throws SQLException {
        String make = rs.getString("make");
        String model = rs.getString("model");
        Integer maxSpeed = rs.getInt("maxSpeed");
        Car car = new Car(make, model, maxSpeed);
        car.setIdCar(rs.getInt("idCar"));
        return car;
    }

    @Override
    public List<Car> getAll() throws DAOException, ConnectException {
        PreparedStatement stat = null;
        Connection conn = getConnection();
        ResultSet rs = null;
        List<Car> cars = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GET_ALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                cars.add(convert(rs));
            }
        } catch (SQLException e) {
            throw new DAOException("SQL ERROR.", e);
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
        return cars;
    }

    @Override
    public Car getById(int id) throws DAOException, ConnectException {
        PreparedStatement stat = null;
        Connection conn = getConnection();
        ResultSet rs = null;
        Car a;
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
            throw new DAOException("SQL ERROR.", e);
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
