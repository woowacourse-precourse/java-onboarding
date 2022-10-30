package onboarding;

import onboarding.problem4.Problem4Validation;

import java.util.stream.Collectors;

public class Problem4 {
    private static final int MIN_INPUT = 1;
    private static final int MAX_INPUT = 1000;

    private static final char LOWER_A = 'a';
    private static final char LOWER_Z = 'z';
    private static final char UPPER_A = 'A';
    private static final char UPPER_Z = 'Z';

    public static String solution(String word) {
        String result = "";

        if (Problem4Validation.problem4InputValidation(word, MIN_INPUT, MAX_INPUT)) {
            result = stringToReverseString(word);
        }

        return result;

    }

    private static String stringToReverseString(String word) {
        StringBuilder resultStringBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            resultStringBuilder.append(charToReserveChar(word.charAt(i)));
        }
        return resultStringBuilder.toString();
    }

    private static char charToReserveChar(char charWord) {

        char reversedChar = charWord;

        if ('a' <= charWord && charWord <= 'z') {
            reversedChar =  (char) (LOWER_Z - (charWord - LOWER_A));
        } else if ('A' <= charWord && charWord <= 'Z') {
            reversedChar =  (char) (UPPER_Z - (charWord - UPPER_A));
        }

        return reversedChar;
    }


}
