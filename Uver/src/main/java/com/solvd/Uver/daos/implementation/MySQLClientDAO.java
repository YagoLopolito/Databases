package com.solvd.Uver.daos.implementation;

import com.solvd.Uver.daos.ClientDAO;
import com.solvd.Uver.entities.Client;
import com.solvd.Uver.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLClientDAO implements ClientDAO {
    private final static String INSERT = "INSERT INTO client(idClient, firstName, lastName, isForDriver, isForMailing) VALUES(?, ?, ?, ?, ?)";
    private final static String UPDATE = "UPDATE client SET idClient = ?, firstName = ?, lastName = ?, isForDriver = ?, isForMailing WHERE idClient = ?";
    private final static String DELETE = "DELETE FROM client WHERE idClient = ?";
    private final static String GET_ALL = "SELECT idClient, firstName, lastName, isForDriver, isForMailing FROM client";
    private final static String GET_ONE = "SELECT idClient, firstName, lastName, isForDriver, isForMailing FROM client WHERE idClient = ?";
    private final Connection conn;

    public MySQLClientDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Client a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setInt(1, a.getIdClient());
            stat.setString(2, a.getFirstName());
            stat.setString(3, a.getLastName());
            stat.setBoolean(4, a.isForDriver());
            stat.setBoolean(4, a.isForMailing());

            if (stat.executeUpdate() == 0) {
                throw new DAOException("May not have been saved");
            }

        } catch (SQLException e) {
            throw new DAOException("SQL ERROR.", e);
        } finally {

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
    public void delete(int a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(DELETE);
            stat.setInt(1, a);

            if (stat.executeUpdate() == 0) {
                throw new DAOException("May not have been saved");
            }

        } catch (SQLException e) {
            throw new DAOException("SQL ERROR.", e);
        } finally {

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
    public void modify(Client a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setInt(1, a.getIdClient());
            stat.setString(2, a.getFirstName());
            stat.setString(3, a.getLastName());
            stat.setBoolean(4, a.isForDriver());
            stat.setBoolean(4, a.isForMailing());

            if (stat.executeUpdate() == 0) {
                throw new DAOException("May not have been saved");
            }

        } catch (SQLException e) {
            throw new DAOException("SQL ERROR.", e);
        } finally {

            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new DAOException("SQL ERROR.", e);
                }
            }
        }
    }

    private Client convert(ResultSet rs) throws SQLException {

        String firstName = rs.getString("firstName");
        String lastName = rs.getString("lastName");
        boolean isForDriver = rs.getBoolean("isForDriver");
        boolean isForMailing = rs.getBoolean("isForMailing");

        return null;
    }

    @Override
    public List<Client> giveAll() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Client> clients = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GET_ALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                clients.add(convert(rs));
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
        return clients;
    }

    @Override
    public Client give(Integer id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Client a = null;
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
