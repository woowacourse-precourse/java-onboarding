package onboarding;

import onboarding.problem2Validation.Problem2Validation;

public class Problem2 {

    private final static int INPUT_MAX_LENGTH = 1000;
    private final static int INPUT_MIN_LENGTH = 1;

    public static String solution(String cryptogram) {
        if (Problem2Validation.problem2InputValidation(cryptogram, INPUT_MIN_LENGTH, INPUT_MAX_LENGTH)) {
            String answer = "answer";
            return answer;
        } else {
            return "";
        }
    }



}
