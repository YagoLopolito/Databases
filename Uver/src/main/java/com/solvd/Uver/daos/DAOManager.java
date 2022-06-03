package com.solvd.Uver.daos;

public interface DAOManager {
    CarDAO getCarDAO();

    DriverDAO getDriverDAO();

    MotorcycleDAO getMotorcycleDAO();

    SuperCarDAO getSuperCarDAO();

    SuperMotoDAO getSuperMotoDAO();
}
