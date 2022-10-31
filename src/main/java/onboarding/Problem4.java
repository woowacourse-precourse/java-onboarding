package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        List<Character> contraryAlphabetArray = new ArrayList<>();
        String answer = "";

        for (int i = 0; i < word.length(); i++){
            char character = word.charAt(i);
            answer += contraryAlphabet(character);
        }

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
