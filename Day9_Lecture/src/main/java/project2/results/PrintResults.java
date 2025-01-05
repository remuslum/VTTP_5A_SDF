package src.main.java.project2.results;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintResults {
    public PrintResults(){

    }

    public Map<String, Integer> trackGuesses(List<Integer> subList, int shuffledNumber){
        Map<String, Integer> counter = new HashMap<>();
        counter.put("Lower", 0);
        counter.put("Higher", 0);

        if (subList.size() > 1){
            for(int number:subList){
                if (number < shuffledNumber){
                    counter.put("Lower", counter.get("Lower") + 1);
                } else if (number > shuffledNumber){
                    counter.put("Higher", counter.get("Higher") + 1);
                }
            }
        }
        return counter;
    }
}
