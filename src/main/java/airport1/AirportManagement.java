package airport1;

/*Used polymorphism with at least one abstract class.
Used 3 Protected variables*/
public abstract class AirportManagement {
    protected String airportId;
    protected String airportName;
    protected String airportLocation;

    public AirportManagement() {
        //System.out.println("Welcome to" + " " + airportName);
    }

    //Abstract method that must be implemented in the child classes
    public abstract void getAirportDetails(String airportId, String airportName, String airportLocation);
}