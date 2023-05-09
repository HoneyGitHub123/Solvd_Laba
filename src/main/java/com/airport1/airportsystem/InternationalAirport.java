package com.airport1.airportsystem;

import com.airport2.airportsystem.Airport;

import java.util.List;

public class InternationalAirport extends Airport {
    private List<String> flights;

    public InternationalAirport(String airportName, String airportLocation, List<String> flights) {
        super(airportName, airportLocation);
        this.flights = flights;
    }


    public List<String> getFlights() {
        return flights;
    }
    //Abstract method overriding
    @Override
    public void displayInformation() {

        System.out.println("List of International Flights: " + flights);
    }
}

