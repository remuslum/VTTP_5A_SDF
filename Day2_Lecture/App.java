import java.util.ArrayList;
import java.util.List;

import object.Computer;
import object.Desktop;
import object.Laptop;
import vehicle.Car;
import vehicle.Truck;
import vehicle.Vehicle;

public class App {
    public static void main(String[] args) {
        
        Computer computer = new Computer();
        computer.setCPU("5GHz 8 core");
        computer.setModel("Asus 8000");
        computer.setRAM(32);
        computer.setYear(2024);

        computer.start();
        computer.displaySpec();
        computer.shutDown();

        Computer computer2 = new Computer();
        computer2.start();
        computer2.displaySpec();
        computer2.shutDown();

        Laptop laptop1 = new Laptop();
        laptop1.setCPU("10Ghz 128 core");
        laptop1.setModel("Asus 12000");
        laptop1.setRAM(64);
        laptop1.setYear(2024);
        laptop1.setBattery("11.1V 3S LIPO");
        laptop1.setOperatingSystem("Windows 11 Professional");
        laptop1.setScreenSize("15.4 inch OLED");
        laptop1.start();
        laptop1.displaySpec();
        laptop1.shutDown();

        Desktop desktop1 = new Desktop("4GHz 8 core", "Alibaba", 16, 2024, "Ubuntu 20.4 LTS", 5, true);
        desktop1.start();
        desktop1.displaySpec();
        desktop1.shutDown();
        
        List<Computer> machines = new ArrayList<>();
        machines.add(desktop1);
        machines.add(computer);
        machines.add(computer2);
        machines.add(laptop1);

        // For statement to display machines
        for (Computer machine : machines) {
            machine.displaySpec();
        }

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("1 Series","BMW",2013));
        vehicles.add(new Car("sedan",5,"100", "Audi", 1994));
        vehicles.add(new Truck(300.78, "Chavdar", "Toyota", 2005));
        
        for (Vehicle v:vehicles) {
            whatIsMyType(v);
        }
    }

    public static void whatIsMyType(Object obj) {
        if (obj instanceof Car) {
            System.out.println("This is a car");
        } else if (obj instanceof Truck) {
            System.out.println("This is a truck");
        } else {
            System.out.println("This is a vehicle");
        }
    }

    //compile
    // javac --source-path . ./*.java object/*.java vehicle/*.java 
    // note the dot after path

    //run
    // java -cp target App

    //JAR file (in target folder)
    // jar -c -v -f sdf02l.jar -e App

    //run package
    // java -jar sdf02l.jar
    
}
