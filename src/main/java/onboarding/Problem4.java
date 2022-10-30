package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static int characterClassification(char word) {
        if (word >= 65 && word <= 90) {
            return 1;
        } else if (word >= 97 && word <= 122) {
            return 2;
        }
        return 0;
    }

    private static char alphabeticalTransformation(char word, int size) {
        if (size == 1) {

        } else if (size == 2) {

        }
        return word;
    }

    private static char greenFrogDictionary(char word) {
        Map<Character, Character> dictionary = new HashMap<>();

    }

}
