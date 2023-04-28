package airport1;

import airport.Salary;

/*Used polymorphism with at least one abstract class.
Used 2 protected variables
Added interface to the abstract class*/

public abstract class Employees implements Salary {
    protected String employeeName;
    protected String employeeId;

    public Employees() {
    }

    //Abstract method that must  be implemented in the child classes
    public abstract void getEmployeeDetails();
}
