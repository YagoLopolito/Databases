package com.solvd.Uver.entities;

import java.util.Objects;

public class Employee {
    int idEmployees, wage;
    String firstName, lastName, position;

    public Employee(String firstName, String lastName, String position, Integer wage) {
    }

    public Employee(int idEmployees, int wage, String firstName, String lastName, String position) {
        this.idEmployees = idEmployees;
        this.wage = wage;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }

    public int getIdEmployees() {
        return idEmployees;
    }

    public void setIdEmployees(int idEmployees) {
        this.idEmployees = idEmployees;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return idEmployees == employee.idEmployees && wage == employee.wage && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(position, employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmployees, wage, firstName, lastName, position);
    }

    @Override
    public String toString() {
        return "Employees{" +
                "idEmployees=" + idEmployees +
                ", wage=" + wage +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
