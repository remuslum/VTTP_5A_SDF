package src.main.java.project1.number;

import java.util.Random;

public class NumberGenerator {
    private final int numberOfDigits;

    public NumberGenerator(int numberOfDigits) {
        this.numberOfDigits = numberOfDigits;
    }

    public int generate() {
        Random random = new Random();
        int min = 1;
        int max = 9;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numberOfDigits; i++){
            sb.append(String.valueOf(min + random.nextInt(max - min + 1)));
        }
        return Integer.parseInt(sb.toString());
    }

}
