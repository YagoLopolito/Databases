package com.solvd.Uver.daos;

public interface DAOManager {
    CarDAO getCarDAO();

    ClientDAO gerClientDAO();

    DeliveryManDAO getDeliveryManDAO();

    DriverDAO getDriverDAO();

    EmployeeDAO getEmployeeDAO();

    MotorcycleDAO getMotorcycleDAO();

    OrderDAO getOrderDAO();

    SuperCarDAO getSuperCarDAO();

    SuperMotoDAO getSuperMotoDAO();
}
