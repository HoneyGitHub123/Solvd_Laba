package threads;

public class AirportRunnable implements Runnable {

    public String name;

    public AirportRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " " + "is Open!");
    }
}
