package com.solvd.Uver.daos.implementation;

import com.solvd.Uver.daos.DeliveryManDAO;
import com.solvd.Uver.entities.DeliveryMan;
import com.solvd.Uver.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLDeliveryManDAO implements DeliveryManDAO {
    private final static String INSERT = "INSERT INTO deliveryMan(idDeliveryMan, firstName, lastName, wage) VALUES(?, ?, ?, ?)";
    private final static String UPDATE = "UPDATE deliveryMan SET idDeliveryMan = ?, firstName = ?, lastName = ?, wage = ? WHERE idDeliveryMan = ?";
    private final static String DELETE = "DELETE FROM deliveryMan WHERE idDeliveryMan = ?";
    private final static String GET_ALL = "SELECT idDeliveryMan, firstName, lastName, wage FROM deliveryMan";
    private final static String GET_ONE = "SELECT idDeliveryMan, firstName, lastName, wage FROM deliveryMan WHERE idDeliveryMan = ?";
    private final Connection conn;

    public MySQLDeliveryManDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(DeliveryMan a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setInt(1, a.getIdDeliveryMan());
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
    public void modify(DeliveryMan a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setInt(1, a.getIdDeliveryMan());
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

    private DeliveryMan convert(ResultSet rs) throws SQLException {
        String firstName = rs.getString("firstName");
        String lastName = rs.getString("lastName");
        Integer wage = rs.getInt("wage");
        DeliveryMan deliveryMan = new DeliveryMan(firstName, lastName, wage);
        deliveryMan.setIdDeliveryMan(rs.getInt("idDeliveryMan"));
        return deliveryMan;
    }

    @Override
    public List<DeliveryMan> giveAll() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<DeliveryMan> deliveryMans = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GET_ALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                deliveryMans.add(convert(rs));
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
        return deliveryMans;
    }

    @Override
    public DeliveryMan give(Integer id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        DeliveryMan a = null;
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
