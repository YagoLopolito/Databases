package com.solvd.Uver.daos.implementation;

import com.solvd.Uver.daos.OrderDAO;
import com.solvd.Uver.entities.Order;
import com.solvd.Uver.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLOrderDAO implements OrderDAO {
    final String INSERT = "INSERT INTO order(idOrder, destination, distance, estimatedTimeOfArrival) VALUES(?, ?, ?, ?)";
    final String UPDATE = "UPDATE order SET idOrder = ?, destination = ?, distance = ?, estimatedTimeOfArrival = ? WHERE idOrder = ?";
    final String DELETE = "DELETE FROM order WHERE idOrder = ?";
    final String GETALL = "SELECT idOrder, destination, distance, estimatedTimeOfArrival FROM order";
    final String GETONE = "SELECT idOrder, destination, distance, estimatedTimeOfArrival FROM order WHERE idOrder = ?";
    private final Connection conn;

    public MySQLOrderDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Order a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setInt(1, a.getIdOrder());
            stat.setString(2, a.getDestination());
            stat.setInt(3, a.getDistance());
            stat.setInt(4, a.getEstimatedTimeOfArrival());

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
    public void modify(Order a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setInt(1, a.getIdOrder());
            stat.setString(2, a.getDestination());
            stat.setInt(3, a.getDistance());
            stat.setInt(4, a.getEstimatedTimeOfArrival());

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

    private Order convert(ResultSet rs) throws SQLException {
        String destination = rs.getString("destination");
        Integer distance = rs.getInt("distance");
        Integer estimatedTimeOfArrival = rs.getInt("estimatedTimeOfArrival");
        Order order = new Order(destination, distance, estimatedTimeOfArrival);
        order.setIdOrder(rs.getInt("idOrder"));
        return order;
    }

    @Override
    public List<Order> giveAll() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Order> orders = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                orders.add(convert(rs));
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
        return orders;
    }

    @Override
    public Order give(Integer id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Order a = null;
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

