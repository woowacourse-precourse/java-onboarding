package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder convertedString = new StringBuilder();
        ConvertMap convertMap = new ConvertMap(getConvertMap());

        char[] letters = word.toCharArray();
        for (char letter : letters) {
            addConvertedAlphabet(convertedString, convertMap, letter);
        }

        return convertedString.toString();
    }

    private static Map<Character, Character> getConvertMap() {
        Map<Character, Character> convertMap = new HashMap<>();
        convertMap.putAll(getUpperCaseConvertMap());
        convertMap.putAll(getLowerCaseConvertMap());

        return convertMap;
    }

    private static Map<Character, Character> getUpperCaseConvertMap() {
        Map<Character, Character> upperCaseConvertMap = new HashMap<>();
        char upperCaseKey = 'A';
        char upperCaseValue = 'Z';
        makeConvertMap(upperCaseConvertMap, upperCaseKey, upperCaseValue);

        return upperCaseConvertMap;
    }

    private static Map<Character, Character> getLowerCaseConvertMap() {
        Map<Character, Character> lowerCaseConvertMap = new HashMap<>();
        char lowerCaseKey = 'a';
        char lowerCaseValue = 'z';
        makeConvertMap(lowerCaseConvertMap, lowerCaseKey, lowerCaseValue);

        return lowerCaseConvertMap;
    }

    private static void makeConvertMap(Map<Character, Character> convertMap, char key, char value) {
        // A~Z ,also a~z, has 26 alphabet
        for (int i = 0; i < 26; i++) {
            convertMap.put(key, value);
            key = increaseKeyCharacter(key);
            value = decreaseValueCharacter(value);
        }
    }

    private static char increaseKeyCharacter(char key) {
        return (char) (key + 1);
    }

    private static char decreaseValueCharacter(char value) {
        return (char) (value - 1);
    }

    private static void addConvertedAlphabet(StringBuilder convertedString, ConvertMap convertMap, char letter) {
        if (Character.isAlphabetic(letter)) {
            char convertedAlphabet = convertMap.getConvertedAlphabet(letter);
            convertedString.append(convertedAlphabet);
            return;
        }

        convertedString.append(letter);
    }

    static class ConvertMap {
        private final Map<Character, Character> convertMap;

        public ConvertMap(Map<Character, Character> convertMap) {
            this.convertMap = convertMap;
        }

        public char getConvertedAlphabet(char alphabet) {
            return convertMap.get(alphabet);
        }
    }
}
