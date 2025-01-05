package vehicle;

public class Vehicle implements IVehicle {
    private String model;
    private String make;
    private int year;
    private int speed;

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void start() {
        System.out.println("Vehicle started ...");
    }

    @Override
    public void stop() {
        this.speed = 0;
        System.out.println("Vehicle stopped ...");
    }

    @Override
    public void accelerate(int increment) {
        this.speed += increment;
        
    }

    @Override
    public void brake(int decrement) {
        this.speed -= decrement;
    }

    @Override
    public void honk() {
        System.out.println("Vehicle honked ...");
    }

}
