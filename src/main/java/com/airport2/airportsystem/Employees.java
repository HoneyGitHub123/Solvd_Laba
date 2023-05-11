package com.airport2.airportsystem;

import com.airport1.airportsystem.Salary;

/*Used polymorphism with at least one abstract class.
Used 2 protected variables
Added interface to the abstract class*/


public abstract class Employees implements Salary {
    protected String employeeName;
    protected String employeeId;

    public Employees(String employeeName,String employeeId) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    //Abstract method that must  be implemented in the child classes
    public abstract void getEmployeeDetails();
}
