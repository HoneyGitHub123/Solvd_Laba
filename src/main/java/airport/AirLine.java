package airport;

import airport1.AirportManagement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//Created and override at least one abstract method from parent class
//used static final variables and method
//created final class
//Try Catch with resources
public final class AirLine extends AirportManagement {
    //static final variable
    public static final String airline = "Qatar Airlines";

    //Default Constructor
    AirLine() {

    }

    //Abstract method implementation in child class.
    @Override
    public void getAirportDetails(String airportId, String airportName,
                                  String airportLocation) {
        System.out.println("Welcome to" + " " + airportName);
        System.out.println("Airport ID:" + airportId);
        System.out.println("Airport Name:" + airportName);
        System.out.println("Airport Location:" + airportLocation);
    }

    //Method Overloading
    public void getAirportDetails() {
        System.out.println("*****************");
    }

    //Static final method
    public static final void getAirlineDetails() {
        System.out.println("Airline Details");
        System.out.println("================");

    }

    public static void displayAirlines() throws IOException {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src/main/resources/input.txt");

            {
                int inputByte = 0;
                while ((inputByte = fis.read()) != -1) {
                    System.out.print((char) inputByte);

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);

        } catch (IOException e) {
            System.out.println(e);


        } catch (Exception e) {
            System.out.println("Unknown Exception" + e);

        } finally {

            fis.close();
        }
    }

    public void getNumberOfFlights() {
        System.out.println("Airline and Number of flights");
        System.out.println("==============================");

    }
}


