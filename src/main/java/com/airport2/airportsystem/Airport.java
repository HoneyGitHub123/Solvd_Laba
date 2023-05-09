package com.airport2.airportsystem;

public abstract class Airport {
    protected String airportName;
    protected String airportLocation;

    public Airport(String airportName,
                   String airportLocation) {
        this.airportName = airportName;
        this.airportLocation = airportLocation;
    }

    public String getName() {
        return airportName;
    }

    public String getLocation() {
        return airportLocation;

    }

    public void getAirportDetails() {
        System.out.println("Welcome to" + " " + airportName);
        System.out.println("Location:" + airportLocation);

    }



    public abstract void displayInformation();


}


