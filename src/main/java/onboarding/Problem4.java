package onboarding;

import onboarding.problem4.Problem4Validation;

public class Problem4 {
    private final static int MIN_INPUT = 1;
    private final static int MAX_INPUT = 1000;
    public static String solution(String word) {
        if (Problem4Validation.problem4InputValidation(word, MIN_INPUT, MAX_INPUT)) {
            String answer = wordToReverseWord(word);
            return answer;
        } else {
            return "";
        }

    }

    private static String wordToReverseWord(String word) {
        return null;
    }
}
