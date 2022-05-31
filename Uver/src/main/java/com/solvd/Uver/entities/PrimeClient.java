package com.solvd.Uver.entities;

import java.util.Objects;

public class PrimeClient {
    int idPrimeClients;
    String firstName, lastName;
    boolean isForMailing, isForDriver, hasPresidentialMenu;

    public PrimeClient() {
    }

    public PrimeClient(int idPrimeClients, String firstName, String lastName, boolean isForMailing, boolean isForDriver, boolean hasPresidentialMenu) {
        this.idPrimeClients = idPrimeClients;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isForMailing = isForMailing;
        this.isForDriver = isForDriver;
        this.hasPresidentialMenu = hasPresidentialMenu;
    }

    public int getIdPrimeClients() {
        return idPrimeClients;
    }

    public void setIdPrimeClients(int idPrimeClients) {
        this.idPrimeClients = idPrimeClients;
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

    public boolean isHasPresidentialMenu() {
        return hasPresidentialMenu;
    }

    public void setHasPresidentialMenu(boolean hasPresidentialMenu) {
        this.hasPresidentialMenu = hasPresidentialMenu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrimeClient that = (PrimeClient) o;
        return idPrimeClients == that.idPrimeClients && isForMailing == that.isForMailing && isForDriver == that.isForDriver && hasPresidentialMenu == that.hasPresidentialMenu && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPrimeClients, firstName, lastName, isForMailing, isForDriver, hasPresidentialMenu);
    }

    @Override
    public String toString() {
        return "PrimeClients{" +
                "idPrimeClients=" + idPrimeClients +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isForMailing=" + isForMailing +
                ", isForDriver=" + isForDriver +
                ", hasPresidentialMenu=" + hasPresidentialMenu +
                '}';
    }
}
