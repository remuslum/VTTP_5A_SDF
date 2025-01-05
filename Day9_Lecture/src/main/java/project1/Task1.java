package src.main.java.project1;

import java.io.Console;
import src.main.java.project1.number.NumberGenerator;
import src.main.java.project1.parser.Parser;

public class Task1 {
    public static void main(String[] args) {
        Console console = System.console();
        Parser parser = new Parser();
        NumberGenerator numberGenerator = new NumberGenerator(6);
        int answer = numberGenerator.generate();
        String userInput = "";
        System.out.println("Welcome! Start by making a guess");

        while (true) {
            userInput = console.readLine("Your guess: ");
            int userInputNumber = parser.parse(userInput);
            if (userInputNumber == 0){
                System.out.println("Bye bye!");
                break;
            } else if (userInputNumber == -1) {
                continue;
            } else if (userInputNumber < answer){
                System.out.println("This guess seems to be too small, try a higher number.");
            } else if (userInputNumber > answer){
                System.out.println("Oops, looks like your guess is a little too high");
            } else {
                System.out.println("Congratulations, you have won!");
                System.out.println("--------------------------------");
                answer = numberGenerator.generate();
            }   
        }
    }
}