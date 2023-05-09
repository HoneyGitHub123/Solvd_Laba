package com.airport1.airportsystem;

public interface Payment {
    //Abstract method
    void getPayment(String cardNum, String currency, double price);
}
