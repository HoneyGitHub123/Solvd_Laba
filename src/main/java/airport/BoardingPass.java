package airport;

//Used set and get methods for private variables
public class BoardingPass {
    private int terminal;
    private String gate;
    Passenger passenger;
    Flight flight;

    BoardingPass(Passenger passenger, Flight flight) {
        this.passenger = passenger;
        this.flight = flight;
    }

    public void getPassengerDetails() {
        System.out.println("BoardingPass");
        System.out.println("==================");
        System.out.print("Passenger Name:" + passenger.passengerName);
        System.out.print("\tPassenger ID:" + passenger.passengerId);
        System.out.println("\t\t\tTicket ID:" + passenger.ticketId);
        System.out.print("Seat Number:" + passenger.seatNo);
        System.out.print("\t\t\t\tClass:" + passenger.classType);
    }

    public void getFlightDetails() {
        System.out.println("\t\t\t\tFlight Name:" + flight.flightName);
        System.out.print("Source:" + flight.source);
        System.out.println("\t\t\t\t\tDestination:" + flight.destination);
        System.out.print("Departure:" + flight.departure);
        System.out.println("\t\tArrival:" + flight.arrival);
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


}

