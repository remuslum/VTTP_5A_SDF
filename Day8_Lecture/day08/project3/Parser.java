package day08.project3;

public class Parser {
    public Parser() {

    }

    public int parse(String input){
        try {
            int guessInInt = Integer.parseInt(input);
            if (guessInInt < 1111 || guessInInt > 6666) {
                System.out.println("You have entered an invalid number. Please enter a number between 1111 and 6666.");
                return -1;
            }
            return guessInInt;
        } catch (NumberFormatException e) {
            System.out.println("Invaild input, please only put numbers.");
            return -1;
        }
    }
}
