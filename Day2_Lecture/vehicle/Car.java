package vehicle;

public class Car extends Vehicle {
    public String carType;
    public int numberOfPassengers;

    public Car(String carType, int numberOfPassengers, String make, String model, int year) {
        super(make, model, year);
        this.carType = carType;
        this.numberOfPassengers = numberOfPassengers;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public void start() {
        System.out.println("Car started ...");
    }

    @Override
    public void stop() {
        this.setSpeed(0);
        System.out.println("Car stopped ...");
    }

    @Override
    public void accelerate(int increment) {
        this.setSpeed(this.getSpeed() + increment + 10);   
    }

    // @Override
    // public void brake(int decrement) {
    //     this.setSpeed(this.getSpeed() - decrement);
    // }

    @Override
    public void honk() {
        System.out.println("Beep...beep...beep...");
    }


}
