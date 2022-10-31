package onboarding;

import java.util.regex.Pattern;

public class Problem4 {
    public static String solution(String word) {
        String answer = getTranslatedWord(word);

        return answer;
    }

    static String getTranslatedWord(String word) {
        int len = word.length();
        StringBuilder translatedWord = new StringBuilder();

        for (int i = 0; i < len; i++) {
            char character = word.charAt(i);
            char translatedChar = getTranslatedChar(character);

            translatedWord.append(translatedChar);
        }

        return translatedWord.toString();
    }

    static Character getTranslatedChar(char character) {
        boolean isAlphabet = isAlphabet(character);

        if (isAlphabet) {
            System.out.println("alphabet");
            return getConvertedChar(character);
        }

        return character;
    }

    static boolean isAlphabet(char character) {
        String pattern = "[a-zA-Z]";
        boolean regex = Pattern.matches(pattern, Character.toString(character));

        return regex;
    }

    static Character getConvertedChar(char character) {
        char convertedChar;

        if (isUpperCase(character)) {
            convertedChar = upperCaseConversion(character);
            return convertedChar;
        }

        convertedChar = lowerCaseConversion(character);

        return convertedChar;
    }

    static boolean isUpperCase(char character) {
        if (character >= 'A' && character <= 'Z') {
            return true;
        }

        return false;
    }

    static Character upperCaseConversion(char character) {
        int move = character - 'A';
        char result = (char)('Z' - move);

        return result;
    }

    static Character lowerCaseConversion(char character) {
        int move = character - 'a';
        char result = (char)('z' - move);

        return result;
    }
}
