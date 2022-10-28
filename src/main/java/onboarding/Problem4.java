package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
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


    private static Map<Character, Character> getUpperCaseConvertMap() {
        Map<Character, Character> upperCaseConvertMap = new HashMap<>();
        char upperCaseKey = 'A';
        char upperCaseValue = 'Z';
        //while(upperCaseKey <= 'Z')
        while (upperCaseKey<=90) {
            upperCaseConvertMap.put(upperCaseKey,upperCaseValue);
            upperCaseKey = increaseKeyCharacter(upperCaseKey);
            upperCaseValue = decreaseValueCharacter(upperCaseValue);
        }
        return upperCaseConvertMap;
    }

    private static Map<Character, Character> getLowerCaseConvertMap() {
        Map<Character, Character> lowerCaseConvertMap = new HashMap<>();
        char lowerCaseKey = 'a';
        char lowerCaseValue = 'z';
        //while(upperCaseKey <= 'z')
        while (lowerCaseKey<=122) {
            lowerCaseConvertMap.put(lowerCaseKey,lowerCaseValue);
            lowerCaseKey = increaseKeyCharacter(lowerCaseKey);
            lowerCaseValue = decreaseValueCharacter(lowerCaseValue);
        }

        return lowerCaseConvertMap;
    }

    private static Map<Character, Character> getConvertMap() {
        Map<Character, Character> convertMap = new HashMap<>();
        convertMap.putAll(getUpperCaseConvertMap());
        convertMap.putAll(getLowerCaseConvertMap());

        return convertMap;
    }
}
