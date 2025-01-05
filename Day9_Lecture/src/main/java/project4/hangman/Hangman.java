package src.main.java.project4.hangman;

import java.util.List;

public class Hangman {
    private final String word;
    
    public Hangman(String word) {
        this.word = word;
    }

    public boolean run(String guess, List<String> guessedList){
        boolean didWordChange = false;
        for (int j = 0; j < word.length(); j++){
            String letter = Character.toString(word.charAt(j));
            if(letter.equals(guess)){
                guessedList.set(j, letter);
                if (!didWordChange){
                    didWordChange = !didWordChange;
                }
            }
        }
        System.out.println("Current progress: " + guessedList);
        return didWordChange;
    }
    
}
