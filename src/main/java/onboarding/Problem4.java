package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static final int MAX_WORD_LENGTH = 1000;

    public static final int COUNTS_OF_ALPHABET = 26;
    public static final int ASCII_CODE_OF_LAST_UPPERCASE_ALPHABET = 90;
    public static final int ASCII_CODE_OF_LAST_LOWERCASE_ALPHABET = 122;

    private static final List<Character> UPPERCASE_LETTERS = new ArrayList<>();
    private static final List<Character> LOWERCASE_LETTERS = new ArrayList<>();

    public static String solution(String word) {
        try {
            validateLength(word);
        } catch (IllegalArgumentException e) {
            return e.toString();
        }

        initLetters();
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
}
