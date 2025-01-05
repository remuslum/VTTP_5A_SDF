package day08.project3;

import java.util.List;
import java.util.stream.Collectors;

public class Evaluator {
    public Evaluator() {

    }

    public void evaluate(List<Integer> rightDigitsCounter, String guess, String answer){
        List<Character> answerList = answer.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> guessList = guess.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        rightDigitsCounter.set(0, evaluateRightNumberRightPosition(answerList, guessList));
        rightDigitsCounter.set(1, evaluateRightNumberWrongPosition(answerList, guessList));
    }

    private int evaluateRightNumberRightPosition(List<Character> answerList, List<Character> guessList){
        int count = 0;
        for(int i = 0; i < guessList.size(); i++){
            if(guessList.get(i).equals(answerList.get(i))){
                count++;
            }
        }
        return count;
    }

    private int evaluateRightNumberWrongPosition(List<Character> answerList, List<Character> guessList){
        int count = 0;
        for(int i = 0; i < guessList.size(); i++){
            if(!guessList.get(i).equals(answerList.get(i)) && answerList.contains(guessList.get(i))){
                count++;
            } 
        }
        return count;
    }
    
}
