package src.main.java.project4.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public ReadFile(){

    }

    public List<String> readFile(String filePath) throws IOException{
        List<String> wordList = new ArrayList<>();
        File file = new File(filePath);
        FileReader reader = new FileReader(file);
        BufferedReader br = new BufferedReader(reader);
        String line = "";

        while((line = br.readLine()) != null){
            wordList.add(line);
        }

        br.close();
        return wordList;
    }
}
