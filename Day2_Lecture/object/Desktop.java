package object;

public class Desktop extends Computer{
    private String operatingSystem;
    private int weight;
    private boolean waterCooling;

    public Desktop() {

    }

    public Desktop(String cpu, String model, int ram, int year, String operatingSystem, int weight, boolean waterCooling) {
        super(cpu,model,ram,year);
        this.operatingSystem = operatingSystem;
        this.weight = weight;
        this.waterCooling = waterCooling;
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

    public boolean isWaterCooling() {
        return waterCooling;
    }

    public void setWaterCooling(boolean waterCooling) {
        this.waterCooling = waterCooling;
    }

    @Override
    public void displaySpec() {
        System.out.println("This desktop specifications:");
        System.out.println(this.getCPU());
        System.out.println(this.getRAM());
        System.out.println(this.getModel());
        System.out.println(this.getYear());
        System.out.println(this.getOperatingSystem());
        System.out.println(this.getOperatingSystem());
        System.out.println(this.isWaterCooling());
        System.out.println(this.getWeight());
    }
}
