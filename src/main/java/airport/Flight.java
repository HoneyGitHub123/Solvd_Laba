package airport;

public class Flight {
    String flightName;
    String source;
    String destination;
    String departure;
    String arrival;

    Flight(String flightName, String source, String destination,
           String departure, String arrival) {

        this.flightName = flightName;
        this.source = source;
        this.destination = destination;
        this.departure = departure;
        this.arrival = arrival;
    }
}
