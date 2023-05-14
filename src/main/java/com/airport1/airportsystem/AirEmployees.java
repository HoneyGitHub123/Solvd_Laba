package com.airport1.airportsystem;

import java.util.List;
import java.util.Objects;

import com.airport2.airportsystem.Employees;
import exceptions.SalaryException;

//Class that implement Interface
public class AirEmployees extends Employees implements Salary, Bonus {
    private String department;
    private String designation;
    private double hourlyRate;


   public AirEmployees(String employeeName, String employeeId, String department,
                 String designation, double hourlyRate) {
        super(employeeName, employeeId);
        this.department = department;
        this.designation = designation;
        this.hourlyRate = hourlyRate;
    }


    public double getHourlyRate() {
        return hourlyRate;
    }

    public String getDesignation() {
        return designation;
    }

    public String getDepartment() {
        return department;
    }


    public void sortEmployee(List<String> unsortedList) {
        System.out.println("list of  employees after sorting:");
        unsortedList.stream().sorted().forEach(System.out::println);
    }

    //Abstract method from parent class is implemented
    @Override
    public void getEmployeeDetails() {
        System.out.println("AirEmployee Details");
        System.out.println("=================");

    }

    //Used override method from class Object toString()
    @Override
    public String toString() {
        return "\nEmployee Name:" + this.employeeName + "\tEmployee ID:" + " " + this.employeeId
                + "\tEmployee Department:" + this.department + "\tEmployee Designation:"
                + this.designation + "\tHourly Rate:" + this.hourlyRate;
    }

    //Used override method from class Object equals().
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        AirEmployees obj1 = (AirEmployees) obj;
        return (obj1.employeeName.equals(this.employeeName)
                && obj1.employeeId.equals(this.employeeId)
                && obj1.department.equals(this.department)
                && obj1.designation.equals(this.designation)
                && obj1.hourlyRate == (this.hourlyRate));
    }

    //Used override method from class Object hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(employeeName, employeeId, department, designation, hourlyRate);

    }

    //Implementing abstract method from Interface
    public double calculateSalary() {
        return hourlyRate * workingHours * 20;
    }

    //Custom exception
    public void checkSalary(double salary) throws SalaryException {
        if (salary < 2400) {

            System.out.println("\nSalary Computed is wrong for" + " " + employeeName);
            throw new SalaryException("Salary amount is less than minimum salary amount.Minimum salary for the employee is 2400 USD");

        } else {
            System.out.println();
            System.out.println("Salary of the employee in USD:" + employeeName + " " + salary);
            System.out.println("Total salary of the employee including bonus in USD:" + calculateBonus());
        }

    }

    //Implementing abstract method from Interface
    public double calculateBonus() {
        return calculateSalary() + bonusAmount;
    }
}
