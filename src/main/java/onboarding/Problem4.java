package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static final int MAX_WORD_LENGTH = 1000;

    public static final int COUNTS_OF_ALPHABET = 26;

    public static final int ASCII_CODE_OF_FIRST_UPPERCASE_ALPHABET = 65;
    public static final int ASCII_CODE_OF_FIRST_LOWERCASE_ALPHABET = 97;
    public static final int ASCII_CODE_OF_LAST_UPPERCASE_ALPHABET = 90;
    public static final int ASCII_CODE_OF_LAST_LOWERCASE_ALPHABET = 122;

    private static final List<Character> UPPERCASE_LETTERS = new ArrayList<>();
    private static final List<Character> LOWERCASE_LETTERS = new ArrayList<>();

    public static String solution(String word) {
        try {
            validateLength(word);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        initLetters();

        return makeReversedWord(word);
    }

    public static void validateLength(String word) {
        if (word.length() < 1 || word.length() > MAX_WORD_LENGTH) {
            throw new IllegalArgumentException("허용되지 않은 길이의 문자열입니다.");
        }
    }

    private static void initLetters() {
        initUppercaseLetters();
        initLowercaseLetters();
    }

    private static void initUppercaseLetters() {
        for (int index = 0; index < COUNTS_OF_ALPHABET; index++) {
            UPPERCASE_LETTERS.add((char) (ASCII_CODE_OF_LAST_UPPERCASE_ALPHABET - index));
        }
    }

    private static void initLowercaseLetters() {
        for (int index = 0; index < COUNTS_OF_ALPHABET; index++) {
            LOWERCASE_LETTERS.add((char) (ASCII_CODE_OF_LAST_LOWERCASE_ALPHABET - index));
        }
    }

    private static String makeReversedWord(String word) {
        String reversedWord = "";
        char[] letters = word.toCharArray();

        for (char letter : letters) {
            reversedWord += convertLetter(letter);
        }

        return reversedWord;
    }

    private static char convertLetter(char letter) {
        if (isUppercaseLetter(letter)) {
            return convertUppercaseLetter(letter);
        }

        if (isLowercaseLetter(letter)) {
            return convertLowercaseLetter(letter);
        }

        return letter;
    }

    private static char convertLowercaseLetter(char letter) {
        return LOWERCASE_LETTERS.get(letter - ASCII_CODE_OF_FIRST_LOWERCASE_ALPHABET);
    }

    private static char convertUppercaseLetter(char letter) {
        return UPPERCASE_LETTERS.get(letter - ASCII_CODE_OF_FIRST_UPPERCASE_ALPHABET);
    }

    private static boolean isUppercaseLetter(char letter) {
        return (letter > ASCII_CODE_OF_FIRST_UPPERCASE_ALPHABET && letter < ASCII_CODE_OF_LAST_UPPERCASE_ALPHABET);
    }

    private static boolean isLowercaseLetter(char letter) {
        return (letter > ASCII_CODE_OF_FIRST_LOWERCASE_ALPHABET && letter < ASCII_CODE_OF_LAST_LOWERCASE_ALPHABET);
    }
}