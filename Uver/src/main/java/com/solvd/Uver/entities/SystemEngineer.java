package com.solvd.Uver.entities;

import java.util.Objects;

public class SystemEngineer {
    int idSystemEngineers, wage;
    String firstName, lastName;

    public SystemEngineer() {
    }

    public SystemEngineer(int idSystemEngineers, int wage, String firstName, String lastName) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SystemEngineer that = (SystemEngineer) o;
        return idSystemEngineers == that.idSystemEngineers && wage == that.wage && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSystemEngineers, wage, firstName, lastName);
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
