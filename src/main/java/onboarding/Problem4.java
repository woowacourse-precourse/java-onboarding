package onboarding;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Problem4 {

    private static final String SPLIT_VALUE = "";
    private static final char NOTHING = ' ';
    private static final int LETTER_CHARACTER_INDEX = 0;
    private static final int ALPHABET_UPPER_CASE_MAX_ASCII_CODE = 'Z';
    private static final int ALPHABET_DOWN_CASE_MAX_ASCII_CODE = 'z';
    private static final int ALPHABET_TOTAL_SIZE = 'Z' - 'A';

    public static String solution(String word) {
        return reverseWord(word);
    }

    private static String reverseWord(String word) {
        String[] letters = parseToLetters(word);
        String reversedWord =
                Arrays.stream(letters)
                        .map(letter -> parseLetter(letter))
                        .collect(Collectors.joining());

        return reversedWord;
    }

    private static String parseLetter(String letter) {
        char checkableLetter = convertToCheckableLetter(letter);
        char parsedLetter = parseCheckableLetter(checkableLetter);
        return parseToWord(parsedLetter);
    }

    private static char parseCheckableLetter(char letter) {
        if (checkNotAlphabetic(letter)) {
            return letter;
        }
        return reverseLetter(letter);
    }

    private static String[] parseToLetters(String word) {
        return word.split(SPLIT_VALUE);
    }

    private static String parseToWord(char parsedLetter) {
        return String.valueOf(parsedLetter);
    }

    private static char reverseLetter(char letter) {
        char reversedLetter = NOTHING;
        if (checkUpperCase(letter)) {
            reversedLetter = reverseUpperCaseLetter(letter);
        }
        if (checkDownCase(letter)) {
            reversedLetter = reverseDownCaseLetter(letter);
        }
        return reversedLetter;
    }

    private static char reverseUpperCaseLetter(char letter) {
        return (char) (ALPHABET_UPPER_CASE_MAX_ASCII_CODE * 2 - letter - ALPHABET_TOTAL_SIZE);
    }

    private static char reverseDownCaseLetter(char letter) {
        return (char) (ALPHABET_DOWN_CASE_MAX_ASCII_CODE * 2 - letter - ALPHABET_TOTAL_SIZE);
    }

    private static boolean checkUpperCase(char letter) {
        return Character.isUpperCase(letter);
    }

    private static boolean checkDownCase(char letter) {
        return !Character.isUpperCase(letter);
    }

    private static boolean checkNotAlphabetic(char letter) {
        return !Character.isAlphabetic(letter);
    }

    private static char convertToCheckableLetter(String letter) {
        return letter.charAt(LETTER_CHARACTER_INDEX);
    }

}
