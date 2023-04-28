package airport;

import java.util.Objects;

import airport1.Employees;
import exceptions.SalaryException;

//Class that implement Interface
public class AirEmployees extends Employees implements Salary, Bonus {
    private String department;
    private String designation;
    private double hourlyRate;

    AirEmployees(String employeeName, String employeeId, String department,
                 String designation, double hourlyRate) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.department = department;
        this.designation = designation;
        this.hourlyRate = hourlyRate;
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
        return "Employee Name:" + " " + this.employeeName + "\nEmployee ID:" + " " + this.employeeId
                + "\nEmployee Department:" + " " + this.department + "\nEmployee Designation:"
                + " " + this.designation + "\nHourly Rate:" + " " + this.hourlyRate;
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
        double sal = hourlyRate * workingHours;
        return sal;
    }

    //Custom exception
    public void checkSalary(double salary) throws SalaryException {
        if (salary < 1200) {
            throw new SalaryException("Salary amount is less than minimum salary amount.Minimum salary for the employee is 1200 USD");

        } else {
            System.out.println("Salary of the employee in USD:" + salary);

        }

    }

    //Implementing abstract method from Interface
    public double calculateBonus() {
        return calculateSalary() + bonusAmount;
    }
}
