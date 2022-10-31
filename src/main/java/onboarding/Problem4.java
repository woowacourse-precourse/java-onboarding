package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        List<Character> contraryAlphabetArray = new ArrayList<>();
        String answer = "";
        return answer;
    }
    public static char contraryAlphabet(char word) {
        if (!(Character.isAlphabetic(word))) {
            return word;
        }
        if (Character.isUpperCase(word)) {
            return (char) ('A' + ('Z' - word));
        } else {
            return  (char) ('a' + ('z' - word));
        }
    }
}
