package src.main.java.project4;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import src.main.java.project4.file.ReadFile;
import src.main.java.project4.hangman.Hangman;

public class Task5 {
    public static void main(String[] args) throws IOException{
        ReadFile readFile = new ReadFile();
        Random random = new Random();
        Console console = System.console();
        List<String> wordList = readFile.readFile(args[0]);
        int numberOfLivesLeft = 12;
        int randomWordIndex = random.nextInt(wordList.size() - 1);
        String word = wordList.get(randomWordIndex);        

        List<String> guessedList = new ArrayList<>();

        for(int i = 0; i < word.length(); i++){
            guessedList.add("_");
        }

        String userInput = "";
        System.out.println(word);
        Hangman hangman = new Hangman(word);
        while(numberOfLivesLeft != 0){
            if(!guessedList.contains("_")){
                System.out.println("Congratulations! You have won!");
                break;
            }
            userInput = console.readLine("Enter a letter: ");
            boolean didWordChange = hangman.run(userInput, guessedList);
            if(!didWordChange){
                numberOfLivesLeft--;
            }
            System.out.println("Number of lives left: " + numberOfLivesLeft);
        }
        if(numberOfLivesLeft == 0){
            System.out.println("Sorry, you have lost.");
        }
        
    }
}
