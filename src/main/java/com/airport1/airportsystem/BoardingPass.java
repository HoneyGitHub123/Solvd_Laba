package com.airport1.airportsystem;

//Used set and get methods for private variables
public class BoardingPass extends Passenger implements Flight {
    private int terminal;
    private String gate;

    BoardingPass(String passengerName, int passengerId, String tickedId, String seatNo, String classType) {
        super(passengerName, passengerId, tickedId, seatNo, classType);
    }


    public void setGate(String gate) {
        this.gate = gate;
    }

    public void setTerminal(int terminal) {
        this.terminal = terminal;
    }

    public String getGate() {
        return gate;
    }

    public int getTerminal() {
        return terminal;
    }

    public void displayBoardingPass() {
        System.out.println("BoardingPass");
        System.out.println("==================");


    }
    //Implementing abstract methods of Interface
    public void getFlightDetails(String flightName, String source, String destination,
                                 String departure, String arrival) {
        System.out.println("\t\t\t\tFlight Name:" + flightName);
        System.out.print("Source:" + source);
        System.out.println("\t\t\t\t\tDestination:" + destination);
        System.out.print("Departure:" + departure);
        System.out.println("\t\tArrival:" + arrival);


    }


}






