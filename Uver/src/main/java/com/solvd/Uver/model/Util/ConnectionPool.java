package com.solvd.Uver.model.Util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private final String URL = DBPropertiesUtil.getString(Constants.URL);
    private final String USER = DBPropertiesUtil.getString(com.solvd.Uver.model.Util.Constants.USERNAME);
    private final String PASS = DBPropertiesUtil.getString(com.solvd.Uver.model.Util.Constants.PASSWORD);
    private static ConnectionPool datasource;
    private BasicDataSource basicDataSource = null;


    private final static int MAX_CONNECTIONS = DBPropertiesUtil.getInt(com.solvd.Uver.model.Util.Constants.MAX_CONNECTIONS);
    private int createdConnectionsAmount = 0;

    private final List<Connection> connectionList = new ArrayList<>(MAX_CONNECTIONS);


    private ConnectionPool() {
        basicDataSource = new BasicDataSource();
        basicDataSource.setUsername(USER);
        basicDataSource.setPassword(PASS);
        basicDataSource.setUrl(URL);
        basicDataSource.setInitialSize(2);
        basicDataSource.setMinIdle(3);
        basicDataSource.setMaxIdle(20);
        basicDataSource.setMaxTotal(40);
        basicDataSource.setMaxWaitMillis(10000);
    }

    public static ConnectionPool getInstance() {
        if (datasource == null) {
            datasource = new ConnectionPool();
            return datasource;
        } else {
            return datasource;
        }
    }

    public Connection getConnection() {
        if (!connectionList.isEmpty()) {
            return connectionList.remove(0);
        } else if (createdConnectionsAmount < MAX_CONNECTIONS) {
            return createConnection();
        } else {
            throw new ConnectionException("There is no available connection. Limits are reached.");
        }

    }

    private Connection createConnection() {
        Connection conn = null;
        try {
            conn = this.basicDataSource.getConnection();
            createdConnectionsAmount++;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }

    public void returnConnection(Connection connection) {
        connectionList.add(connection);
    }

    public int getCreatedConnectionsAmount() {
        return createdConnectionsAmount;
    }
}
