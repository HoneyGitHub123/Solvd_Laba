package airport;

import airport1.AirportManagement;
import exceptions.LuggageCountException;
import exceptions.MinimumRateException;
import exceptions.PassportNumberException;
import exceptions.SalaryException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

//Class with main() which will instantiate objects of implemented classes
//Used polymorphism with the abstract class and interface from the hierarchy
//Static block used
//Custom exceptions executed

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    //Example for static block
    static {
        System.out.println("Implementation of Airport System");
        logger.info("Static block executed");
    }

    public static void main(String[] args) throws IOException {
        AirportManagement am = new AirLine();
        //This is an example for dynamic binding.Type of the object is determined at run time
        am.getAirportDetails("LAX124", "Los Angeles International Airport", "California");
        logger.info("Displayed Airport details");
        AirLine al = new AirLine();
        //This is an example for static binding.Type of the object is determined at compile time
        al.getAirportDetails();
        AirLine.getAirlineDetails();
        AirLine.displayAirlines();
        //Calling static final method from main class without object
        System.out.println();
        TicketReservation tr = new TicketReservation();
        int num1 = tr.getCustomerDetails("John Math", "156 N street", 9087990, 999999999);
        try {
            tr.checkPassportNum(num1);
        } catch (PassportNumberException p) {
            // p.printStackTrace();
            logger.warn("PassportNumberException caught");
            logger.error("Invalid Passport number");
            System.out.println(p);
        }
        tr.getFlightDetails();
        tr.bookSeat("A12", "Economy");
        tr.getPayment("5574656546", "USD", 1500);
        Passenger psg = new Passenger("John Math", 100012, "QTR9898", "A12", "Economy");
        Passenger psg1 = new Passenger("John Math", 100012, "QTR9898", "A12", "Economy");
        psg.getPassengerDetails();
        System.out.println(psg);
        System.out.println("Comparing two passenger objects psg,psg1:True or False?" + psg.equals(psg1));
        System.out.println(psg.hashCode());
        System.out.println(psg1.hashCode());
        Flight fgt = new Flight("QTR01", "LAX", "DOH", "Apr 20,3:00PM", "Apr 21,10:00PM");
        BoardingPass bps = new BoardingPass(psg, fgt);
        bps.getPassengerDetails();
        bps.getFlightDetails();
        bps.setGate("A10");
        System.out.print("Gate:" + bps.getGate());
        bps.setTerminal(7);
        System.out.println("\t\t\t\t\tTerminal:" + bps.getTerminal());
        Luggage lug = new Luggage();
        lug.setLuggageId("LG1009");
        System.out.println("*************************");
        System.out.println("Luggage ID:" + lug.getLuggageId());
        lug.setLuggageCount(-2);
        try {
            lug.checkLuggageCount();
        } catch (LuggageCountException l) {
            // l.printStackTrace();
            logger.warn("LuggageCountException caught");
            logger.error("Invalid luggage count");
            System.out.println(l);
        }
        GroundEmployees ge = new GroundEmployees("John", "7856", "Enquiry Department", "Associate", 5);
        GroundEmployees ge1 = new GroundEmployees("John", "7856", "Enquiry Department", "Associate", 45);
        ge.getEmployeeDetails();
        System.out.println(ge);
        try {
            ge.checkMinimumRate();
        } catch (MinimumRateException e1) {
            //e1.printStackTrace();
            logger.info("try-catch custom Exception");
            logger.info("MinimumWage Exception caught");
            System.out.println(e1);
        }
        System.out.println(ge1);
        System.out.println("Comparing two Ground Employees objects ae & ae1:True or False?" + ge.equals(ge1));
        System.out.println(ge.hashCode());
        System.out.println(ge1.hashCode());
        AirEmployees ae = new AirEmployees("Maria", "1456", "Cabin Crew", "Associate", 10);
        AirEmployees ae1 = new AirEmployees("Anna", "1980", "Cabin Crew", "Senior", 40);
        ae.getEmployeeDetails();
        System.out.println(ae);
        double sal = ae.calculateSalary();
        try {
            ae.checkSalary(sal);
        } catch (SalaryException e) {
            logger.info("try-catch custom Exception");
            //e.printStackTrace();
            logger.info("SalaryException caught");
            System.out.println(e);
        }
        System.out.println("Salary of the employee in USD:" + sal);
        System.out.println("Total salary of the employee including bonus in USD:" + ae.calculateBonus());
        //AirEmployees ae1 = new AirEmployees("Anna", "1980", "Cabin Crew", "Senior", 40);
        System.out.println(ae1);
        double sal1 = ae1.calculateSalary();
        System.out.println("Salary of the employee in USD:" + sal1);
        System.out.println("Total salary of the employee including bonus in USD:" + ae1.calculateBonus());
        System.out.println("Comparing two Air Employees objects ae & ae1:True or False?" + ae1.equals(ae));
        System.out.println(ae.hashCode());
        System.out.println(ae1.hashCode());


    }
}
