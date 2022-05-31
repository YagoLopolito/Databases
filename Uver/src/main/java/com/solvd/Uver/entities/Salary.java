package com.solvd.Uver.entities;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salary salary = (Salary) o;
        return idSalary == salary.idSalary && mount == salary.mount && employeeId == salary.employeeId && isPaid == salary.isPaid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSalary, mount, employeeId, isPaid);
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
