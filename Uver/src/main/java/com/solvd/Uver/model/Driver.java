package com.solvd.Uver.model;

public class Driver {
    int idSystemEngineers, wage;
    String firstName, lastName, sex;

    public Driver() {
    }

    public Driver(int idSystemEngineers, int wage, String firstName, String lastName, String sex) {
        this.idSystemEngineers = idSystemEngineers;
        this.wage = wage;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
    }

    public int getIdSystemEngineers() {
        return idSystemEngineers;
    }

    public void setIdSystemEngineers(int idSystemEngineers) {
        this.idSystemEngineers = idSystemEngineers;
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
    public String toString() {
        return "Drivers{" +
                "idSystemEngineers=" + idSystemEngineers +
                ", wage=" + wage +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
