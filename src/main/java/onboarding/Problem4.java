package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder makingConvertedString = new StringBuilder();
        ConvertMap convertMap = new ConvertMap(getConvertMap());

        char[] letters = word.toCharArray();
        for (char token : letters) {
            addTokenToMakingConvertedString(makingConvertedString, convertMap, token);
        }
        String convertedString = makingConvertedString.toString();

        return convertedString;
    }

    private static void addTokenToMakingConvertedString(StringBuilder makingConvertedString, ConvertMap convertMap, char token) {
        if (Character.isAlphabetic(token)) {
            char convertedLetter = convertMap.getConvertedLetter(token);
            makingConvertedString.append(convertedLetter);
            return ;
        }

        makingConvertedString.append(token);
    }


    static class ConvertMap{
        private final Map<Character, Character> convertMap;

        public ConvertMap(Map<Character, Character> convertMap) {
            this.convertMap = convertMap;
        }

        public char getConvertedLetter(char letter) {
            return convertMap.get(letter);
        }
    }

    private static char increaseKeyCharacter(char key) {
        char increasedKeyCharacter = (char) (key + 1);
        return increasedKeyCharacter;
    }

    private static char decreaseValueCharacter(char value) {
        char decreasedValueCharacter = (char) (value - 1);
        return decreasedValueCharacter;
    }

    private static void makeConvertMap(Map<Character, Character> convertMap, char key, char value) {
        // A~Z ,also a~z, has 26 alphabet
        for (int i = 0; i < 26; i++) {
            convertMap.put(key, value);
            key = increaseKeyCharacter(key);
            value = decreaseValueCharacter(value);
        }
    }

    private static Map<Character, Character> getUpperCaseConvertMap() {
        Map<Character, Character> upperCaseConvertMap = new HashMap<>();
        char upperCaseKey = 'A';
        char upperCaseValue = 'Z';

        //making upperCaseConvertMap
        makeConvertMap(upperCaseConvertMap,upperCaseKey,upperCaseValue);

        return upperCaseConvertMap;
    }

    private static Map<Character, Character> getLowerCaseConvertMap() {
        Map<Character, Character> lowerCaseConvertMap = new HashMap<>();
        char lowerCaseKey = 'a';
        char lowerCaseValue = 'z';

        //making lowerCaseConvertMap
        makeConvertMap(lowerCaseConvertMap,lowerCaseKey,lowerCaseValue);

        return lowerCaseConvertMap;
    }

    private static Map<Character, Character> getConvertMap() {
        Map<Character, Character> convertMap = new HashMap<>();
        convertMap.putAll(getUpperCaseConvertMap());
        convertMap.putAll(getLowerCaseConvertMap());

        return convertMap;
    }
}
