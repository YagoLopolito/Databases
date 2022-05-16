package com.solvd.Uver.model;

public class SystemEngineers {
    int idSystemEngineers, wage;
    String firstName, lastName;

    public SystemEngineers() {
    }

    public SystemEngineers(int idSystemEngineers, int wage, String firstName, String lastName) {
        this.idSystemEngineers = idSystemEngineers;
        this.wage = wage;
        this.firstName = firstName;
        this.lastName = lastName;
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

    @Override
    public String toString() {
        return "SystemEngineers{" +
                "idSystemEngineers=" + idSystemEngineers +
                ", wage=" + wage +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
