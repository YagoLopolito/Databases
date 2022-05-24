package com.solvd.Uver.model;

public class Client {
    int idClient;
    String firstName, lastName;
    boolean isForMailing, isForDriver;

    public Client() {
    }

    public Client(int idClient, String firstName, String lastName, boolean isForMailing, boolean isForDriver) {
        this.idClient = idClient;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isForMailing = isForMailing;
        this.isForDriver = isForDriver;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
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

    public boolean isForMailing() {
        return isForMailing;
    }

    public void setForMailing(boolean forMailing) {
        isForMailing = forMailing;
    }

    public boolean isForDriver() {
        return isForDriver;
    }

    public void setForDriver(boolean forDriver) {
        isForDriver = forDriver;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "idClient=" + idClient +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isForMailing=" + isForMailing +
                ", isForDriver=" + isForDriver +
                '}';
    }
}
