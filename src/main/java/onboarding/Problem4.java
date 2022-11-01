package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        return translate(word);
    }
    static HashMap<Character, Character> createDictionary() {
        HashMap<Character, Character> dictionary = new HashMap<>();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] alphabetReversed = "zyxwvutsrqponmlkjihgfedcba".toCharArray();
        for (int i = 0; i < alphabet.length; i ++) {
            dictionary.put(alphabet[i], alphabetReversed[i]);
        }
        return dictionary;
    }
    static String translate(String word) {
        HashMap<Character, Character> rule = createDictionary();
        StringBuilder translated = new StringBuilder();
        char letter, tLetter;

        for (int i = 0; i < word.length(); i ++) {
            letter = word.charAt(i);
            if (Character.isAlphabetic(letter)) {
                tLetter = rule.get(Character.toLowerCase(letter));
                if (Character.isUpperCase(letter)) {
                    translated.append(Character.toUpperCase(tLetter));
                } else {
                    translated.append(tLetter);
                }
            }
            else {
                translated.append(letter);
            }
        }
        return translated.toString();
    }
}
