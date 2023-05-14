package com.enums;

import java.util.Arrays;

//enum with fields
public enum GroundSignal {
    STEADY_GREEN("Cleared for takeoff"),
    FLASHING_GREEN("Cleared for Taxi"),
    STEADY_RED("STOP"),
    FLASHING_RED("Taxi clear of the runway in use");

    //public String airSignal;
    public String groundSignal;

    GroundSignal(String groundSignal) {
        //this.airSignal = airSignal;
        this.groundSignal = groundSignal;
    }


    public String getGroundSignal() {
        return groundSignal;
    }

    public static GroundSignal getByValue(String message) {
        return Arrays.stream(GroundSignal.values())
                .filter(e -> e.groundSignal.equals(message))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("Wrong Message")));
    }
}

