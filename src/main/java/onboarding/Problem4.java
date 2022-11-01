package onboarding;

import java.util.HashMap;

public class Problem4 {

    public static String solution(String word) {
        HashMap<Character, Character> greenFrogDictionary = createGreenFrogDictionary();
        return getGreenFrogWord(greenFrogDictionary, word);
    }

    private static String getGreenFrogWord(
        HashMap<Character, Character> greenFrogDictionary,
        String word
    ) {
        StringBuilder greenFrogWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            Character greenFrogLetter = greenFrogDictionary.getOrDefault(letter, ' ');
            greenFrogWord.append(greenFrogLetter);
        }
        return greenFrogWord.toString();
    }

    private static HashMap<Character, Character> createGreenFrogDictionary() {
        HashMap<Character, Character> greenFrogDictionary = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            greenFrogDictionary.put((char) ('a' + i), (char) ('z' - i));
            greenFrogDictionary.put((char) ('A' + i), (char) ('Z' - i));
        }
        return greenFrogDictionary;
    }
}
