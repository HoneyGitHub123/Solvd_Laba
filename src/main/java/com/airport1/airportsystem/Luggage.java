package com.airport1.airportsystem;

import exceptions.LuggageCountException;

//Private variables used Getters and Setters
public class Luggage {

    private String luggageId;
    private int luggageCount;

    public void setLuggageId(String luggageId) {
        this.luggageId = luggageId;
    }

    public String getLuggageId() {
        return luggageId;
    }

    public void setLuggageCount(int luggageCount) {
        this.luggageCount = luggageCount;
    }

    public void checkLuggageCount() throws LuggageCountException {
        if (luggageCount < 0) {
            throw new LuggageCountException("Luggage count cannot be negative");
        } else {
            System.out.println("Luggage Count:" + luggageCount);

        }


    }
}


