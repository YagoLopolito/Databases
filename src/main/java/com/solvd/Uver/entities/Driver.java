package com.solvd.Uver.entities;

import com.solvd.Uver.daos.DAOimpl.DriverDAOImpl;
import com.solvd.Uver.exception.DAOException;

import java.net.ConnectException;
import java.util.Objects;

public class Driver{
    int idDriver, wage;
    String firstName, lastName, sex;

    public Driver(String firstName, String lastName, Integer wage) {
        this.wage = wage;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Driver(int idDriver, int wage, String firstName, String lastName, String sex) {

        this.idDriver = idDriver;
        this.wage = wage;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
    }

    public Driver() {

    }

    public int getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(int idDriver) {
        this.idDriver = idDriver;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return idDriver == driver.idDriver && wage == driver.wage && Objects.equals(firstName, driver.firstName) && Objects.equals(lastName, driver.lastName) && Objects.equals(sex, driver.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDriver, wage, firstName, lastName, sex);
    }

    @Override
    public String toString() {
        return  "\n----------------------------------------------------------------\n"
                +"Driver"
                + "\nId Driver: " + idDriver
                + "\nWage: " + wage
                + "\nFirst name: " + firstName
                + "\nLast name: " + lastName
                + "\nSex: " + sex
                + "\n----------------------------------------------------------------"
                ;
    }

//    @Override
//    public void insert() throws DAOException, ConnectException {
//        DriverDAOImpl ddi=new DriverDAOImpl();
//        ddi.insert(this);
//    }
}
