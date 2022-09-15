package edu.java.inheritance08;

abstract class Vehicle{  // 탈것
    public abstract void run();
}

class Bus extends Vehicle{
    @Override
    public void run() {
        System.out.println("버스 run...");
    }
}

class Taxi extends Vehicle{
    @Override
    public void run() {
        System.out.println("Taxi run...");
    }
}

class Driver{
    public void drive(Vehicle v) {
        v.run();
    }
}

public class AbstractMain02 {

    public static void main(String[] args) {
        Driver busDriver = new Driver();
        Bus bus = new Bus();
        busDriver.drive(bus);
        
        Driver taxiDriver = new Driver();
        taxiDriver.drive(new Taxi());
    }

}
