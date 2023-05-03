package airport;

import java.util.Objects;

import airport1.Employees;
import exceptions.MinimumRateException;

//Added interface to the class hierarchy
public class GroundEmployees extends Employees implements Salary, Bonus {

    private String department;
    private String designation;
    private double hourlyRate;

    GroundEmployees(String employeeName, String employeeId, String department,
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
        System.out.println("GroundEmployee Details");
        System.out.println("=================");

    }

    //Used override method from class Object toString()
    @Override
    public String toString() {
        return "\nEmployee Name:" + " " + this.employeeName + "\tEmployee ID:" + " " + this.employeeId
                + "\tEmployee Department:" + " " + this.department + "\tEmployee Designation:"
                + " " + this.designation + "\tHourly Rate:" + " " + this.hourlyRate;
    }

    //Used override method from class Object equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        GroundEmployees obj1 = (GroundEmployees) obj;
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

    public void checkMinimumRate() throws MinimumRateException {
        if (hourlyRate < 15) {
            System.out.println("\nHourly rate of employee" + " " + employeeName + " " + "is less than minimum hourly rate");
            throw new MinimumRateException("Minimum hourly rate of the employee should be greater than 15");

        }

    }

    //Implementing abstract method from Interface.
    public double calculateSalary() {
        return hourlyRate * workingHours;
    }

    //Implementing abstract method from Interface
    public double calculateBonus() {
        return calculateSalary() + bonusAmount;
    }
}



