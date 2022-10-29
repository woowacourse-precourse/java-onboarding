package onboarding;

import onboarding.problem4.Problem4Validation;

import java.util.stream.Collectors;

public class Problem4 {
    private static final int MIN_INPUT = 1;
    private static final int MAX_INPUT = 1000;
    public static String solution(String word) {
        if (Problem4Validation.problem4InputValidation(word, MIN_INPUT, MAX_INPUT)) {
            return stringToReverseString(word);
        } else {
            return "";
        }

    }

    private static String stringToReverseString(String word) {
        StringBuilder resultStringBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            resultStringBuilder.append(charToReserveChar(word.charAt(i)));
        }
        return resultStringBuilder.toString();
    }

    private static char charToReserveChar(char charWord) {
        if ('a' <= charWord && charWord <= 'z') {
            return (char) ('z' - (charWord - 'a'));
        } else if ('A' <= charWord && charWord <= 'Z') {
            return (char) ('Z' - (charWord - 'A'));
        } else {
            return charWord;
        }
    }


}
