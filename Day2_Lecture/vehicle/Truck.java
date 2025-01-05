package vehicle;

public class Truck extends Vehicle {
    private double cargoCapacity;

    public Truck(double cargoCapacity, String make, String model, int year) {
        super(make, model, year);
        this.cargoCapacity = cargoCapacity;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(double cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public void start() {
        System.out.println("Truck started ...");
    }

    @Override
    public void stop() {
        this.setSpeed(0);
        System.out.println("Truck stopped ...");
    }

    @Override
    public void accelerate(int increment) {
        this.setSpeed(this.getSpeed() + increment + 5);   
    }

    // @Override
    // public void brake(int decrement) {
    //     this.setSpeed(this.getSpeed() - decrement);
    // }

    @Override
    public void honk() {
        System.out.println("Beee..p");
    }

    

}
