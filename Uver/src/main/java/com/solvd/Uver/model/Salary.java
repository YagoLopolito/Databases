package com.solvd.Uver.model;

public class Salary {
    int idSalary, mount, employeeId;
    boolean isPaid;

    public Salary() {
    }

    public Salary(int idSalary, int mount, int employeeId, boolean isPaid) {
        this.idSalary = idSalary;
        this.mount = mount;
        this.employeeId = employeeId;
        this.isPaid = isPaid;
    }

    public int getIdSalary() {
        return idSalary;
    }

    public void setIdSalary(int idSalary) {
        this.idSalary = idSalary;
    }

    public int getMount() {
        return mount;
    }

    public void setMount(int mount) {
        this.mount = mount;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "idSalary=" + idSalary +
                ", mount=" + mount +
                ", employeeId=" + employeeId +
                ", isPaid=" + isPaid +
                '}';
    }
}
