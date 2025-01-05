package object;

public class Computer {
    private String CPU;
    private String model;
    private Integer RAM;
    private Integer year;

    public Computer() {
        this.CPU = "2GHZ dual core";
        this.model = "Gigabyte 100";
        this.RAM = 32;
        this.year = 2023;
    }

    public Computer(String CPU, String model, int RAM, Integer year) {
        this.CPU = CPU;
        this.model = model;
        this.RAM = RAM;
        this.year = year;
    }

    // Getters and Setters can be constructed by right clicking and using "Source Action" & "Generate Getters and Setters"
    

    public void start() {
        System.out.println("Computer powered up...");
    }

    public void shutDown() {
        System.out.println("Shutting down computer...");
    }

    public void displaySpec() {
        System.out.println("This computer specifications:");
        System.out.println(this.CPU);
        System.out.println(this.RAM);
        System.out.println(this.model);
        System.out.println(this.year);
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }


}