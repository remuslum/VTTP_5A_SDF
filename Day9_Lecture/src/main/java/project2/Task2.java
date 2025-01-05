package src.main.java.project2;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import src.main.java.project2.evaluator.Evaluator;
import src.main.java.project2.results.PrintResults;

public class Task2 {
    public static void main(String[] args) {
        Console console = System.console();
        Random random = new Random();
        Evaluator evaluator = new Evaluator();
        PrintResults printResults = new PrintResults();
        int min = 1;
        int max = 100;
        List<Integer> listOfRandomNumbers = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            int number = min + random.nextInt(max - min + 1);
            listOfRandomNumbers.add(number);
        }
        Collections.shuffle(listOfRandomNumbers);
        int shuffledNumber = listOfRandomNumbers.get(0);
        System.out.println("Shuffled Number " + shuffledNumber);
        List<String> results = new ArrayList<>();

        for(int i = 1; i < listOfRandomNumbers.size(); i++){
            System.out.println("Make a guess if the next number is higher(h) or lower(l)");
            String userGuess = console.readLine("Your guess: ");
            int nextNumber = listOfRandomNumbers.get(i);
            
            results.add(evaluator.evaluate(nextNumber, shuffledNumber, userGuess));
            StringBuilder sb = new StringBuilder();
            for(String pastGuesses : results) {
                sb.append(pastGuesses);
                sb.append(" ");
            }
            System.out.println(sb.toString());

            List<Integer> subList = listOfRandomNumbers.subList(i, listOfRandomNumbers.size());

            Map<String, Integer> counter = printResults.trackGuesses(subList, shuffledNumber);

            System.out.println("Number of digits that are lower: " + counter.get("Lower"));
            System.out.println("Number of digits that are higher: " + counter.get("Higher"));
        }
        System.out.println("Thanks for playing!");
    }
}
