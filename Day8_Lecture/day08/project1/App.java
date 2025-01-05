package day08.project1;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws IOException,ParseException{
        FileManager fileManager = new FileManager(args[0]);
        List<String> data = fileManager.readFile();
        List<Product> productList = fileManager.convertToProduct(data);

        Product mouse = new Product(LocalDate.of(2023, Month.FEBRUARY, 15), 1, 99.0f, "Computer", "For click UI on screen", "Mouse");
        Product keyboard = new Product(LocalDate.of(2023, Month.JUNE, 20), 2, 235.5f,"Computer", "Device that allows alpha numeric inputs", "Keyboard");
        Product monitor = new Product(LocalDate.of(2023, Month.OCTOBER, 4), 3, 157.5f, "Computer", "Extended display monitor", "15.6 inch monitor");
        Product huaweiPura70 = new Product(LocalDate.of(2024, Month.MARCH, 20), 4, 900.0f, "Mobile", "Huawei phone", "Huawei Pura 70 Ultra");
        Product huaweiMate50 = new Product(LocalDate.of(2024, Month.JULY, 7), 5, 1200.0f, "Mobile", "Huawei phone", "Huawei Mate 50 Pr");
        Product iPhone16Pro = new Product(LocalDate.of(2023, Month.AUGUST, 9), 6, 2000.0f, "Mobile", "iPhone", "iPhone 16 Pro");
        Product iPhone14Pro = new Product(LocalDate.of(2023, Month.SEPTEMBER, 20), 7, 1800.0f, "Mobile", "iPhone", "iPhone 14 Pro");

        productList.add(mouse);
        productList.add(keyboard);
        productList.add(monitor);
        productList.add(huaweiPura70);
        productList.add(huaweiMate50);
        productList.add(iPhone14Pro);
        productList.add(iPhone16Pro);

        List<Product> result = productList.stream().filter(p -> p.getProductCategory().equals("Mobile") && p.getPrice() > 1500.0f).collect(Collectors.toList());
        fileManager.writeToFile(result);
    }
}
