package com.solvd.Uver.entities;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return idClient == client.idClient && isForMailing == client.isForMailing && isForDriver == client.isForDriver && Objects.equals(firstName, client.firstName) && Objects.equals(lastName, client.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClient, firstName, lastName, isForMailing, isForDriver);
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
