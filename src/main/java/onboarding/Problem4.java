package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    static Map<Character, Character> dictionary = new HashMap<>();
    public static String solution(String word) {
        initialDictionary();
        StringBuilder stringBuiler = new StringBuilder(word);
        StringBuilder answer = new StringBuilder();
        char alphabet;
        for (int i = 0; i < stringBuiler.length(); i++) {
            alphabet = stringBuiler.charAt(i);
            char convertedAlphabet = alphabeticalTransformation(alphabet, characterClassification(alphabet));
            answer.append(convertedAlphabet);
        }
        return answer.toString();
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
            return (char) (greenFrogDictionary(word) + 32);
        } else if (size == 2) {
            return greenFrogDictionary(word);
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
