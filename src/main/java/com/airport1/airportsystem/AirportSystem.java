package com.airport1.airportsystem;

import com.airport2.airportsystem.Airport;
import com.enums.AirSignal;
import com.enums.GroundSignal;
import com.utils.AirportInfo;
import exceptions.LuggageCountException;
import exceptions.MinimumRateException;
import exceptions.PassportNumberException;
import exceptions.SalaryException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


//Class with main() which will instantiate objects of implemented classes
//Used polymorphism with the abstract class and interface from the hierarchy
//Static block used
//Custom exceptions executed
//Used Lambda expression with Functional Interface,Consumer Interface,Predicate Interface
//Custom lambda expression used

public class AirportSystem {
    private static final Logger logger = LogManager.getLogger(AirportSystem.class);
    public static final String INPUT_FILE = "src/main/resources/inputMessage.txt";
    public static final String OUTPUT_FILE = "src/main/resources/outputMessage.txt";


    //Example for static block
    static {
        System.out.println("Implementation of Airport System");
        logger.info("Static block executed");
    }

    public static void main(String[] args) throws IOException {
        AirportInfo.getUniqueWordsCount();

        //Lambda expression using Consumer interface,with one parameter and no return value
        System.out.println("Lambda expression implementation using Consumer Interface");
        System.out.println("==============================================================");
        Consumer<String> c = s -> System.out.println(s);
        c.accept("ATC Signals");
        c.accept("===================");
        //enums with fields and methods
        GroundSignal signal = GroundSignal.STEADY_GREEN;
        System.out.println("Message for flights in ground:" + signal.getGroundSignal());
        AirSignal signal1 = AirSignal.FLASHING_GREEN;
        System.out.println("Message for flights in Air:");
        signal1.getMessage();

        List<String> internationalFlight = new ArrayList<>();
        internationalFlight.add("Qatar Airlines:QR123,QR788,QR678");
        internationalFlight.add("Russian Airlines:SU567,SU789");
        internationalFlight.add("Air Canada:AC123,AC324");
        Airport airport = new InternationalAirport("Los Angeles International Airport", "Los Angeles", internationalFlight);
        //This is an example for dynamic binding.Type of the object is determined at run time
        airport.getAirportDetails();
        InternationalAirport airport1 = new InternationalAirport("Los Angeles International Airport", "Los Angeles", internationalFlight);
        //This is an example for static binding.Type of the object is determined at compile time
        airport1.getFlights();
        airport1.displayInformation();
        List<String> domesticFlight = new ArrayList<>();
        domesticFlight.add("JetBlue Airlines:JB123,JB788,JB678");
        domesticFlight.add("Delta Airlines:DL567,DL789");
        domesticFlight.add("American Airlines:AA123,AA324");
        DomesticAirport airport2 = new DomesticAirport("Los Angeles International Airport", "Los Angeles", domesticFlight);
        airport2.getFlights();
        airport2.displayInformation();
        AirLine al = new AirLine();
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
        treeMap.put("CX", 2);
        treeMap.put("CM", 4);
        treeMap.put("DL", 6);
        treeMap.put("EK", 4);

        //Lambda expression using predicate interface,with accept one parameter and returns boolean
        System.out.println("Lambda expression implementation using Predicate Interface");
        System.out.println("==============================================================");
        Predicate<Integer> length = (i) -> (i > 5);
        c.accept("Number of flights available for CX(Cathay Pacific) is greater than 5:" + length.test(treeMap.get("CX")));
        //Treemap will always display the entries in sorted order
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
        List<FlightCapacity> list01 = new ArrayList<>();
        list01.add(flightCapacity);
        list01.add(flightCapacity1);
        list01.add(flightCapacity2);
        list01.add(flightCapacity3);

        //Lambda expression using predicate interface,with accept one object parameter and returns boolean
        System.out.println("Lambda expression implementation using Predicate Interface");
        System.out.println("==============================================================");
        for (FlightCapacity ft : list01) {
            Predicate<FlightCapacity> pr = e -> (e.capacity > 300);
            System.out.println("Capacity of" + " " + ft.getFlightCode() + " " + "is greater than 300:" + pr.test(ft));

        }
        Map<FlightCapacity, String> map = new HashMap();
        map.put(flightCapacity, "Russian Airlines");
        map.put(flightCapacity1, "Qatar Airlines");
        map.put(flightCapacity2, "Hawaiian Airlines");
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
        //Lambda expression
        logger.info("HashSet");
        FlightBoard flightBoard = new FlightBoard("Russian Airlines", "SU765", "5:30", "Moscow", "20A", "On Time");
        FlightBoard flightBoard1 = new FlightBoard("Qatar Airlines", "QTR01", "15:00", "Doha", "10B", "On Time");
        FlightBoard flightBoard2 = new FlightBoard("Hawaiian Airlines", "HA345", "15:30", "Hawaii", "20A", "On Time");
        FlightBoard flightBoard3 = new FlightBoard("Japan Airlines", "JL890", "13:00", "Tokyo", "21A", "delay");
        FlightBoard flightBoard4 = new FlightBoard("Japan Airlines", "JL890", "13:00", "Tokyo", "21A", "delay");
        flightBoard.displayFlightBoard();
        Set<FlightBoard> set = new HashSet<FlightBoard>();
        set.add(flightBoard);
        set.add(flightBoard1);
        set.add(flightBoard2);
        set.add(flightBoard3);
        set.add(flightBoard4);

        //Lambda expression using Function interface,with accept one object parameter and returns a value
        System.out.println("Lambda expression implementation using Function Interface");
        System.out.println("==============================================================");
        System.out.println();
        Function<FlightBoard, String> fn1 = f -> {
            if ((f.remarks).equalsIgnoreCase("delay"))
                return "*Flight is delay.Sorry for the Inconvenience*";
            else
                return "*Flight is on time.Happy Journey*";
        };
        for (FlightBoard fb : set) {
            System.out.println("Status of flight:" + fb.flightId + "------- " + fn1.apply(fb));

        }

        //Adding duplicate values
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
        ticketReservation.getFlightDetails("QTR01", "LAX", "DOH", "Apr 20,3:00PM", "Apr 21,10:00PM");
        ticketReservation.bookSeat("A12", "Economy");
        ticketReservation.getPayment("5574656546", "USD", 1500);
        Passenger passenger = new Passenger("John Math", 100012, "QTR9898", "A12", "Economy");
        Passenger passenger1 = new Passenger("Jason Jim", 100002, "QTR9808", "A22", "Economy");


        System.out.println("Passenger Details");
        System.out.println("================");
        System.out.println(passenger);
        System.out.println("Comparing two passenger objects psg,psg1:True or False?" + passenger.equals(passenger1));
        System.out.println(passenger.hashCode());
        System.out.println(passenger1.hashCode());
        BoardingPass boardingPass = new BoardingPass("John Math", 100012, "QTR9898", "A12", "Economy");
        boardingPass.displayBoardingPass();
        boardingPass.getPassengerDetails();
        boardingPass.getFlightDetails("QTR01", "LAX", "DOH", "Apr 20,3:00PM", "Apr 21,10:00PM");
        boardingPass.getPassengerDetails();
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
        //Lambda expression using Function interface,with accept one parameter and returns a value
        System.out.println("Custom Lambda expression implementation with generics");
        System.out.println("====================================================");
        System.out.println();
        CustomFuncInterface<String, Integer> fn = n -> n.length();
        for (GroundEmployees emp : lt) {
            System.out.println("Length of employee name" + emp.getEmployeeName() + fn.action(emp.getEmployeeName()));


        }
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
        list1.add(airEmployees5);

        //Custom lambda function to update the employee id
        System.out.println("Custom Lambda expression implementation with generics");
        System.out.println("====================================================");
        CustomFuncInterface<AirEmployees, String> se = o1 -> {
            String label = "AE";
            String newId = label.concat(o1.getEmployeeId());
            return newId;
        };
        for (AirEmployees ae : list1) {
            System.out.println("Updated Employee Id of" + " " + ae.getEmployeeName() + " " + se.action(ae));
        }
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




