package object;

public class Laptop extends Computer{
    private String operatingSystem;
    private int weight;
    private String battery;
    private String screenSize;

    public Laptop() {
    }

    public Laptop(String cpu, String model, int ram, int yearMade) {
        super(cpu, model, ram, yearMade);
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    @Override
    public void start() {
        System.out.println("Laptop powered up...");
    }

    @Override
    public void shutDown() {
        System.out.println("Shutting down laptop...");
    }

    @Override
    public void displaySpec() {
        System.out.println("This laptop specifications:");
        System.out.println(this.getCPU());
        System.out.println(this.getRAM());
        System.out.println(this.getModel());
        System.out.println(this.getYear());
        System.out.println(this.getOperatingSystem());
        System.out.println(this.getBattery());
        System.out.println(this.getScreenSize());
        System.out.println(this.getWeight());
    }

    public int computeArithmetic() {
        int a = 1;
        int b = 2;
        int sum;

        sum = a + b;
        return sum;
    }

    public int computeArithmetic(int a, int b) {
        int sum;

        sum = a + b;
        return sum;
    }

}
