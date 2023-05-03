package airport;

import airport1.AirportManagement;
import airport1.Employees;
import exceptions.LuggageCountException;
import exceptions.MinimumRateException;
import exceptions.PassportNumberException;
import exceptions.SalaryException;
import jdk.jfr.FlightRecorder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.*;


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
        //Calling static final method from main class without object
        AirLine.displayAirlines();
        System.out.println();
        al.getNumberOfFlights();
        logger.info("TreeMap is used");
        Map<String, Integer> treeMap = new TreeMap<String, Integer>();
        treeMap.put("SU", 6);
        treeMap.put("AM", 2);
        treeMap.put("AC", 9);
        treeMap.put("CX", 6);
        treeMap.put("CM", 4);
        treeMap.put("DL", 6);
        treeMap.put("EK", 4);
        //Treemap will always display the entires in sorted order
        System.out.println(treeMap);
        System.out.println("Number of flights for AM:" + treeMap.get("AM"));
        treeMap.remove("AC");
        System.out.println("TreeMap after removing values of AC");
        System.out.println(treeMap);
        System.out.println();
        logger.info("HashMap");
        FlightCapacity flightCapacity = new FlightCapacity("SU765", 245);
        FlightCapacity flightCapacity1 = new FlightCapacity("QTR01", 350);
        FlightCapacity flightCapacity2 = new FlightCapacity("HA345", 210);
        FlightCapacity flightCapacity3 = new FlightCapacity("JL890", 300);
        Map<FlightCapacity, String> map = new HashMap();
        map.put(flightCapacity, "Russian Airlines");
        map.put(flightCapacity1, "Qatar Airlines");
        map.put(flightCapacity2, "Hawaaian Airlines");
        map.put(flightCapacity3, "Japan Airlines");
        FlightCapacity.displayCapacity();
        for (Map.Entry<FlightCapacity, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("RunWay Details");
        System.out.println("===============");
        logger.info("Custom linked list Implementation");
        logger.info("Created String type Linked list");
        RunWay<String> linkedList1 = new RunWay<>();
        //Implementing addFist
        linkedList1.addFirst("24R/6L");
        linkedList1.addFirst("24R/6R");
        //Implementing addLast
        linkedList1.addLast("25R/7L");
        linkedList1.addLast("25L/7R");
        System.out.println("\nlist1 after adding Runways :");
        // Print and display the above List elements
        //Implementing print linklist
        linkedList1.printList();
        System.out.println();
        logger.info("Created Integer type Linked list");
        RunWay<Integer> linkedList2 = new RunWay<>();
        // Adding elements to the above List object
        linkedList2.addFirst(8926);
        linkedList2.addFirst(10285);
        linkedList2.addLast(12091);
        linkedList2.addLast(11095);
        System.out.println("SecondList after adding length of runways in feet :");
        //Implementing print linklist
        linkedList2.printList();
        System.out.println();

        logger.info("HashSet");
        FlightBoard flightBoard = new FlightBoard("Russina Airlines", "SU765", "5:30", "Moscow", "20A", "On Time");
        FlightBoard flightBoard1 = new FlightBoard("Qatar Airlines", "QTR01", "15:00", "Doha", "10B", "On Time");
        FlightBoard flightBoard2 = new FlightBoard("Hawaiian Airlines", "HA345", "15:30", "Hawaii", "20A", "On Time");
        FlightBoard flightBoard3 = new FlightBoard("Japan Airlines", "JL890", "13:00", "Tokyo", "21A", "delay 15 minutes");
        FlightBoard flightBoard4 = new FlightBoard("Japan Airlines", "JL890", "13:00", "Tokyo", "21A", "delay 15 minutes");
        flightBoard.displayFlightBoard();
        Set<FlightBoard> set = new HashSet<FlightBoard>();
        set.add(flightBoard);
        set.add(flightBoard1);
        set.add(flightBoard2);
        set.add(flightBoard3);
        set.add(flightBoard4);//Adding duplicate values
        logger.info("Duplicate records are not allowed in set");
        System.out.println(set);//Duplicate record is not allowed
        System.out.println();
        TicketReservation ticketReservation = new TicketReservation();
        int num1 = ticketReservation.getCustomerDetails("John Math", "156 N street", 9087990, 999999999);
        try {
            ticketReservation.checkPassportNum(num1);
        } catch (PassportNumberException p) {
            // p.printStackTrace();
            logger.warn("PassportNumberException caught");
            logger.error("Invalid Passport number");
            System.out.println(p);
        }
        ticketReservation.getFlightDetails();
        ticketReservation.bookSeat("A12", "Economy");
        ticketReservation.getPayment("5574656546", "USD", 1500);
        Passenger passenger = new Passenger("John Math", 100012, "QTR9898", "A12", "Economy");
        Passenger passenger1 = new Passenger("John Math", 100012, "QTR9898", "A12", "Economy");
        passenger.getPassengerDetails();
        System.out.println(passenger);
        System.out.println("Comparing two passenger objects psg,psg1:True or False?" + passenger.equals(passenger1));
        System.out.println(passenger.hashCode());
        System.out.println(passenger1.hashCode());
        Flight flight = new Flight("QTR01", "LAX", "DOH", "Apr 20,3:00PM", "Apr 21,10:00PM");
        BoardingPass boardingPass = new BoardingPass(passenger, flight);
        boardingPass.getPassengerDetails();
        boardingPass.getFlightDetails();
        boardingPass.setGate("A10");
        System.out.print("Gate:" + boardingPass.getGate());
        boardingPass.setTerminal(7);
        System.out.println("\t\t\t\t\tTerminal:" + boardingPass.getTerminal());
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
        GroundEmployees groundEmployees = new GroundEmployees("John", "7856", "Enquiry Department", "Associate", 5);
        GroundEmployees groundEmployees1 = new GroundEmployees("Mathew", "7806", "Security Department", "Associate", 45);
        List<GroundEmployees> lt = new LinkedList<>();
        lt.add(groundEmployees);
        lt.add(groundEmployees1);
        groundEmployees.getEmployeeDetails();
        System.out.println(lt);
        GroundEmployees groundEmployees2 = new GroundEmployees("Teresa", "7800", "Security Department", "Senior", 45);
        logger.info("Adding new element in the linked list");
        lt.add(1, groundEmployees2);
        System.out.println(lt);
        try {
            groundEmployees.checkMinimumRate();
        } catch (MinimumRateException e1) {
            //e1.printStackTrace();
            logger.info("try-catch custom Exception");
            logger.info("MinimumWage Exception caught");
            System.out.println(e1);
        }
        System.out.println("Comparing two Ground Employees objects ae & ae1:True or False?" + groundEmployees.equals(groundEmployees1));
        System.out.println(groundEmployees.hashCode());
        System.out.println(groundEmployees1.hashCode());

        logger.info("ArrayList");
        AirEmployees airEmployees0 = new AirEmployees("Maria", "1458", "Cabin Crew", "Associate", 40);
        AirEmployees airEmployees1 = new AirEmployees("Anna", "1460", "Cabin Crew", "Associate", 20);
        AirEmployees airEmployees2 = new AirEmployees("Sara", "1457", "Cabin Crew", "Senior", 10);
        AirEmployees airEmployees3 = new AirEmployees("John", "1461", "Cabin Crew", "Senior", 40);
        AirEmployees airEmployees4 = new AirEmployees("Luke", "1459", "Cabin Crew", "Senior", 40);
        AirEmployees airEmployees5 = new AirEmployees("Luke", "1459", "Cabin Crew", "Senior", 40);
        airEmployees0.getEmployeeDetails();
        List<AirEmployees> list1 = new ArrayList<AirEmployees>();
        list1.add(airEmployees0);
        list1.add(airEmployees1);
        list1.add(airEmployees2);
        list1.add(airEmployees3);
        list1.add(airEmployees4);
        list1.add(airEmployees5);//duplicate record added to the list
        logger.info("Duplicate records are accepted in the list");
        System.out.println(list1);//duplicate records are allowed
        logger.info("Printing record based on list index");
        System.out.println("Elements at index 3 is :" + list1.get(3));//printing record from index
        try {
            airEmployees0.checkSalary(airEmployees0.calculateSalary());
        } catch (SalaryException e) {
            logger.info("try-catch custom Exception");
            //e.printStackTrace();
            logger.info("SalaryException caught");
            System.out.println(e);
        }
        try {
            airEmployees1.checkSalary(airEmployees1.calculateSalary());
        } catch (SalaryException e1) {
            logger.info("try-catch custom Exception");
            //e.printStackTrace();
            logger.info("SalaryException caught");
            System.out.println(e1);
            System.out.println();

        }

        try {
            airEmployees2.checkSalary(airEmployees2.calculateSalary());
        } catch (SalaryException e2) {
            logger.info("try-catch custom Exception");
            //e.printStackTrace();
            logger.info("SalaryException caught");
            System.out.println(e2);
        }

        try {
            airEmployees3.checkSalary(airEmployees3.calculateSalary());
        } catch (SalaryException e3) {
            logger.info("try-catch custom Exception");
            //e.printStackTrace();
            logger.info("SalaryException caught");
            System.out.println(e3);
        }
        try {
            airEmployees4.checkSalary(airEmployees4.calculateSalary());
        } catch (SalaryException e4) {
            logger.info("try-catch custom Exception");
            //e.printStackTrace();
            logger.info("SalaryException caught");
            System.out.println(e4);

        }
        System.out.println("Comparing two Air Employees objects ae & ae1:True or False?" + airEmployees1.equals(airEmployees0));
        System.out.println(airEmployees0.hashCode());
        System.out.println(airEmployees1.hashCode());


    }
}




