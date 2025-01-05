package src.main.java.project1.parser;

public class Parser {
    public Parser(){

    }

    public int parse(String userInput){
        int errorNumber = -1;
        if (userInput.contains("exit")){
            return 0;
        } else {
            try {
                int userInputNumber = Integer.parseInt(userInput);
                if (userInputNumber < 100000 || userInputNumber > 999999) {
                    System.out.println("The digits entered is invalid, please ensure that you have entered a 6 digit number.");
                    return errorNumber;
                } else {
                    return userInputNumber;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please ensure that you only enter numbers in your guess.");
                return errorNumber;
            }
        }
    }
}
