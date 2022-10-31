package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    static Map<Character, Character> dictionary = new HashMap<>();
    public static String solution(String word) {
        initialDictionary();
        System.out.println("dictionary = " + dictionary);
        StringBuilder answer = new StringBuilder();
        char alphabet;
        for (int i = 0; i < word.length(); i++) {
            alphabet = word.charAt(i);
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
            return getWord(word);
        } else if (size == 2) {
            return (char) (getWord(word) + 32);
        }
        return word;
    }

    private static char getWord(char word) {
        return dictionary.get(word);
    }

    private static void initialDictionary() {
        int reverse = 90;
        for (int i = 65; i <= 90; i++) {
            dictionary.put((char) i, (char) reverse--);
        }
    }

}
