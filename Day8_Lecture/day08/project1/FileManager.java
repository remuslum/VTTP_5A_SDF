package day08.project1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FileManager {
    private final String filePath;

    public FileManager(String filePath){
        this.filePath = filePath;
    }

    public List<String> readFile() throws IOException{
        List<String> data = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        String line ="";
        while((line = br.readLine()) != null){
            data.add(line);
        }
        return data;
    }

    public List<Product> convertToProduct(List<String> productList) throws ParseException{
        List<Product> finalProducts = new ArrayList<>();
        for(String product:productList) {
            String trimmedString = product.substring(9);
            String[] splittedString = trimmedString.split(",");
            Map<String, String> productMap = new HashMap<>();
            for(String element:splittedString) {
                String[] keyAndValue = element.split("=");
                productMap.put(keyAndValue[0].trim(), keyAndValue[1].trim());
            }
                        
            finalProducts.add(new Product(LocalDate.parse(productMap.get("dateCreated")), 
            Long.parseLong(productMap.get("id")), 
            Float.parseFloat(productMap.get("price")), 
            productMap.get("category"), productMap.get("description"), 
            productMap.get("name")));
        }
        return finalProducts;
    }

    public void writeToFile(List<Product> productList) throws IOException{
        FileWriter fileWriter = new FileWriter(new File(this.filePath));
        BufferedWriter bw = new BufferedWriter(fileWriter);
        for(Product product:productList) {
            bw.append(product.toString());
            bw.append("\n");
        }
        bw.flush();
        bw.close();
        fileWriter.close();
    }
}
