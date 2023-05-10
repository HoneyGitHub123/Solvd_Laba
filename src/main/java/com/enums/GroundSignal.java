package com.enums;

//enum with fields
public enum GroundSignal {
    STEADY_GREEN( "Cleared for takeoff"),
    FLASHING_GREEN( "Cleared for Taxi"),
    STEADY_RED( "STOP"),
    FLASHING_RED( "Taxi clear of the runway in use");

    //public String airSignal;
    public String groundSignal;

    GroundSignal(String groundSignal) {
        //this.airSignal = airSignal;
        this.groundSignal = groundSignal;
    }


    public String getGroundSignal() {
        return groundSignal;
    }
}

