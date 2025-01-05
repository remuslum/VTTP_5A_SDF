package day08.project2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
    public static void main(String[] args) {
        String input = "ABCD";
        List<String> permutations = getPermutationsList(input);
        Set<String> permutationSet = new HashSet<>(permutations);
        permutationSet.forEach(System.out::println);
    }

    public static List<String> getPermutationsList(String letters) {
        List<String> permutations = new ArrayList<>();
        generatePermutations(letters, "", permutations);
        return permutations;
    }

    public static void generatePermutations(String letters, String current, List<String> permutations) {
        if (letters.isEmpty()) {
            permutations.add(current);
            return;
        } else {
            for(int i = 0; i < letters.length(); i++) {
                char currentChar = letters.charAt(i);
                String remainingLetters = letters.substring(0, i) + letters.substring(i + 1);
                generatePermutations(remainingLetters, current + currentChar, permutations);
            }
        }
    }
}
