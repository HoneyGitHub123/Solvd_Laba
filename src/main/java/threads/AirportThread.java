package threads;


//import sun.jvm.hotspot.runtime.Threads;

public class AirportThread extends Thread {
    public String name;

    public AirportThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " " + "is Open!");

    }

}
