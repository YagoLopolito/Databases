package com.solvd.Uver.model;

public class PrimeClients {
    int idPrimeClients;
    String firstName, lastName;
    boolean isForMailing, isForDriver, hasPresidentialMenu;

    public PrimeClients() {
    }

    public PrimeClients(int idPrimeClients, String firstName, String lastName, boolean isForMailing, boolean isForDriver, boolean hasPresidentialMenu) {
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
