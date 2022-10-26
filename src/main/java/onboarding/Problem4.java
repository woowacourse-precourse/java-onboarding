package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Problem4 {
    public static final int UPPER_ALPHABET_START_ASCII = 65;
    public static final int UPPER_ALPHABET_END_ASCII = 90;
    public static final int LOWER_ALPHABET_START_ASCII = 97;
    public static final int LOWER_ALPHABET_END_ASCII = 122;

    public static String solution(String word) {
        List<String> changedWordList = new ArrayList<>();
        String[] words = word.split("");

        for (String character : words) {
            character = changeCharacter(character);
            changedWordList.add(character);
        }

        return String.join("", changedWordList);
    }

    private static String changeCharacter(String character) {
        if (checkUpperCase(character)) {
            character = changeUpperCharacter(character);
        }

        if (checkLowerCase(character)) {
            character = changeLowerCharacter(character);
        }

        return character;
    }

    private static boolean checkLowerCase(String character) {
        return Pattern.matches("[a-z]", character);
    }

    private static boolean checkUpperCase(String character) {
        return Pattern.matches("[A-Z]", character);
    }

    private static String changeLowerCharacter(String character) {
        int number = (int)character.charAt(0);
        int newNumber = LOWER_ALPHABET_END_ASCII - (number - LOWER_ALPHABET_START_ASCII);
        return String.valueOf((char)newNumber);
    }

    private static String changeUpperCharacter(String character) {
        int number = (int)character.charAt(0);
        int newNumber = UPPER_ALPHABET_END_ASCII - (number - UPPER_ALPHABET_START_ASCII);
        return String.valueOf((char)newNumber);
    }

}
