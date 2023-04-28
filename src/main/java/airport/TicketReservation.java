package airport;

import exceptions.PassportNumberException;

//Class that implement interfaces.

public class TicketReservation extends Flight implements Customer, Payment {
    TicketReservation() {
        super("QTR01", "LAX", "DOH", "Apr 20,3:00PM", "Apr 21,10:00PM");

    }

    //Implementing methods of Interface

    public int getCustomerDetails(String name, String address, int passportNum, long phoneNum) {
        //calling static final variable from the class AirLine
        System.out.println("Ticket Reservation:" + AirLine.airline);
        System.out.println("================================");
        System.out.println("Name:" + name);
        System.out.println("Address:" + address);
        System.out.println("Phone Number:" + phoneNum);
        System.out.println("Passport Number:" + passportNum);
        return passportNum;

    }

    public void checkPassportNum(int num) throws PassportNumberException {
        int len = (int) (Math.log10(num) + 1);
        if (len < 9) {
            throw new PassportNumberException("Passport Number should be nine digits");
        }
    }

    public void getFlightDetails() {
        System.out.println("Flight Name:" + flightName);
        System.out.println("Source:" + source);
        System.out.println("Destination:" + destination);
        System.out.println("Departure:" + departure);
        System.out.println("Arrival:" + arrival);
    }

    public void bookSeat(String seatNum, String classType) {
        System.out.println("Seat Number:" + seatNum);
        System.out.println("classType:" + classType);
    }

    //Implementing methods from Interface
    public void getPayment(String cardNum, String currency, double price) {
        System.out.println("Card Number:" + cardNum);
        System.out.println("Currency:" + currency);
        System.out.println("Ticket Price:" + price);
    }


}

