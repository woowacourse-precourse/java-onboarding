package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    static Map<Character, Character> dictionary = new HashMap<>();
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
            char result = (char) (greenFrogDictionary(word) + 32);
            return result;
        } else if (size == 2) {
            char result = greenFrogDictionary(word);
            return result;
        }
        return word;
    }

    private static char greenFrogDictionary(char word) {
        return dictionary.get(word);
    }

    private static void initialDictionary() {
        int reverse = 90;
        for (int i = 65; i <= 90; i++) {
            dictionary.put((char) i, (char) reverse--);
        }
    }

}
