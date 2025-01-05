package day08.project3;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mastermind {
    public static void main(String[] args) {
        Random random = new Random();
        int min = 1;
        int max = 6;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 4; i++){
            sb.append(String.valueOf(min + random.nextInt(max - min + 1)));
        }
        int answer = Integer.parseInt(sb.toString());

        Console console = System.console();
        Parser parser = new Parser();
        Evaluator evaluator = new Evaluator();
        String guess = "";
        int numberOfGuesses = 0;
        int numOfDigitsAtRightPosition = 0;
        int numOfRightDigits = 0;
        List<Integer> rightDigitsCounter = new ArrayList<>();
        rightDigitsCounter.add(numOfDigitsAtRightPosition);
        rightDigitsCounter.add(numOfRightDigits);
        
        while(numberOfGuesses < 12) {
            guess = console.readLine("Make your guess: ");
            int guessInInt = parser.parse(guess);
            if (guessInInt == -1){
                continue;
            }
            else {
                if(guessInInt == answer) {
                    System.out.println("You have won!");
                    break;
                } else {
                    evaluator.evaluate(rightDigitsCounter, guess, String.valueOf(answer));
                }
                System.out.printf("Number of digits at the right position: %d \nNumber of right digits guessed: %d \n", rightDigitsCounter.get(0), rightDigitsCounter.get(1));
                numberOfGuesses++; 
            }  
        }
        System.out.println("The number is: " + answer);
    }
}
