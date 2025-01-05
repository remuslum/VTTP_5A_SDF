package vehicle;

public interface IVehicle {
    public void start();
    public void stop();
    public void accelerate(int increment);
    public void brake(int decrement);
    public void honk();
}
