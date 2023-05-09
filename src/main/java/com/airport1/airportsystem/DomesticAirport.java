package com.airport1.airportsystem;

import com.airport2.airportsystem.Airport;

import java.util.List;

public class DomesticAirport extends Airport {
    private List<String> flights;

    public DomesticAirport(String airportName, String airportLocation, List<String> flights) {
        super(airportName, airportLocation);
        this.flights = flights;
    }
    public List<String> getFlights() {
        return flights;
    }

    //Abstract method overriding
    @Override
    public void displayInformation() {
        System.out.println("List of Domestic Flights: " + flights);
    }
}










