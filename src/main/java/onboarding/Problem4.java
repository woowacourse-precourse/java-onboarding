package onboarding;

import onboarding.problem4.Problem4Validation;

import java.util.stream.Collectors;

public class Problem4 {
    private final static int MIN_INPUT = 1;
    private final static int MAX_INPUT = 1000;
    public static String solution(String word) {
        if (Problem4Validation.problem4InputValidation(word, MIN_INPUT, MAX_INPUT)) {
            return wordToReverseWord(word);
        } else {
            return "";
        }

    }

    private static String wordToReverseWord(String word) {
        StringBuilder resultStringBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            resultStringBuilder.append(charToReserveChar(word.charAt(i)));
        }
        return resultStringBuilder.toString();
    }

    private static char charToReserveChar(char charAt) {
        return 0;
    }


}
