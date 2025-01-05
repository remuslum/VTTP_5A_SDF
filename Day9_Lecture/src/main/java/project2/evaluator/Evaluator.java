package src.main.java.project2.evaluator;

public class Evaluator {
    public Evaluator() {

    }

    public String evaluate(int nextNumber, int shuffledNumber, String guess){
        String result = "";
        if (guess.toLowerCase().equals("l")) {
            if (nextNumber < shuffledNumber){
                result = String.valueOf(nextNumber) + ":" + "W";
            } else {
                result = String.valueOf(nextNumber) + ":" + "L";
            }
        } else if (guess.toLowerCase().equals("h")) {
            if (nextNumber > shuffledNumber){
                result = String.valueOf(nextNumber) + ":" + "W";
            } else {
                result = String.valueOf(nextNumber) + ":" + "L";
            }
        }
        return result;
    }

    
}
