package com.solvd.Uver.util;

import com.solvd.Uver.connection.ConnectionPool;

public abstract class AbstractJDBCDao {

    private static ConnectionPool cp;

    static {
        cp = ConnectionPool.getInstance();
    }

    public static ConnectionPool getCp() {
        return cp;
    }

    public static void setCp(ConnectionPool Cp) {
        cp = Cp;
    }

}