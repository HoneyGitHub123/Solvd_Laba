package airport;

import java.util.Objects;

//Calling static method from main class without object
public class Passenger {
    public String passengerName;
    public int passengerId;
    public String ticketId;
    public String seatNo;
    public String classType;

    Passenger(String passengerName, int passengerId, String tickedId, String seatNo, String classType) {

        this.passengerName = passengerName;
        this.passengerId = passengerId;
        this.ticketId = tickedId;
        this.seatNo = seatNo;
        this.classType = classType;
    }

    public void getPassengerDetails() {
        System.out.println("Passenger Details");
        System.out.println("================");

    }

    @Override
    public String toString() {
        return "Passenger Name:" + " " + this.passengerName + "\nPassenger ID:" + " " + this.passengerId +
                "\nTicket ID:" + " " + this.ticketId + "\nSeat Number:" + " " + this.seatNo +
                "\nClass:" + " " + this.classType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Passenger obj1 = (Passenger) obj;
        return (obj1.passengerName.equals(this.passengerName) && obj1.passengerId == (this.passengerId)
                && obj1.ticketId.equals(this.ticketId) && obj1.classType.equals(this.classType)
                && obj1.seatNo.equals(this.seatNo));
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengerName, passengerId, ticketId, classType, seatNo);
    }

}

