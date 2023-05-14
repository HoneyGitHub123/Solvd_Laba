package com.airport1.airportsystem;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class FlightCapacity {
    public String flightCode;
    public int capacity;

    public FlightCapacity(String flightCode, int capacity) {
        this.flightCode = flightCode;
        this.capacity = capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public static final void displayCapacity() {
        System.out.println("\nFlight Capacity");
        System.out.println("================");
    }


    @Override
    public String toString() {
        return "\nFlight Code:" + " " + this.flightCode + " " + "Flight Capacity:" + " " + this.capacity;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        FlightCapacity obj1 = (FlightCapacity) obj;
        return (obj1.flightCode.equals(this.flightCode)
                && obj1.capacity == (this.capacity));

    }

    //Used override method from class Object hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(flightCode, capacity);
    }
}




