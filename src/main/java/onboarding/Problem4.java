package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Problem4 {
    public static final String UPPER = "upper";
    public static final String LOWER = "lower";
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
        String alphabetCase = checkAlphabetCase(character);

        if (alphabetCase != null) {
            character = changeCharacter(character, alphabetCase);
        }

        return character;
    }

    private static String checkAlphabetCase(String character) {
        String alphabetCase = null;

        if (Pattern.matches("[a-z]", character)) {
            alphabetCase = LOWER;
        }

        if (Pattern.matches("[A-Z]", character)) {
            alphabetCase = UPPER;
        }

        return alphabetCase;
    }

    private static String changeCharacter(String character, String alphabetCase) {
        int startAsciiCode = 0;
        int endAsciiCode = 0;

        if (alphabetCase.equals(LOWER)) {
            startAsciiCode = LOWER_ALPHABET_START_ASCII;
            endAsciiCode = LOWER_ALPHABET_END_ASCII;
        }

        if (alphabetCase.equals(UPPER)) {
            startAsciiCode = UPPER_ALPHABET_START_ASCII;
            endAsciiCode = UPPER_ALPHABET_END_ASCII;
        }

        int number = (int) character.charAt(0);
        int newNumber = startAsciiCode - (number - endAsciiCode);
        return String.valueOf((char) newNumber);
    }
}
