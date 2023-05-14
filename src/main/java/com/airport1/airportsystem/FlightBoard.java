package com.airport1.airportsystem;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FlightBoard {

    public String airlineName;
    public String flightId;
    public String schedule;
    public String destination;
    public String remarks;
    public String gateNumber;

    FlightBoard(String airlineName, String flightId, String schedule, String destination, String gateNumber, String remarks) {
        this.airlineName = airlineName;
        this.flightId = flightId;
        this.schedule = schedule;
        this.destination = destination;
        this.gateNumber = gateNumber;
        this.remarks = remarks;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public String getFlightId() {
        return flightId;
    }

    public String getSchedule() {
        return schedule;
    }

    public String getDestination() {
        return destination;
    }

    public String getGateNumber() {
        return gateNumber;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    public List<String> getAirlineName(Collection<FlightBoard> set) {
        List<String> list_01 = set.stream()
                //Non-Terminal operation
                .map(n -> (n.getAirlineName().toUpperCase()))
                //Terminal operation
                .collect(Collectors.toList());
        return list_01;
    }

    public void displayFlightBoard() {
        System.out.println();
        System.out.println("Departures");
        System.out.println("======================");


    }

    @Override
    public String toString() {
        return "\n" + "Airline Name:" + " " + this.airlineName + "\tFlightID:" + " " + this.flightId
                + "\tSchedule:" + " " + this.schedule + "\tDestination:"
                + " " + this.destination + "\tGate:" + " " + this.gateNumber + "\tRemarks:" + " " + this.remarks;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        FlightBoard obj1 = (FlightBoard) obj;
        return (obj1.airlineName.equals(this.airlineName)
                && obj1.flightId.equals(this.flightId)
                && obj1.schedule.equals(this.schedule)
                && obj1.destination.equals(this.destination)
                && obj1.gateNumber.equals(this.gateNumber));
    }

    //Used override method from class Object hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(airlineName, flightId, schedule, destination, gateNumber);
    }

}


