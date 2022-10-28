package onboarding.problem2;

import java.util.Arrays;
import java.util.List;

public class Problem2Validation {
    public static boolean problem2InputValidation(String userInput, int inputMinLength, int inputMaxLength) {
        return inputLengthBetweenMinAndMax(userInput, inputMinLength, inputMaxLength) && isAlphabetAndLower(userInput);
    }

    private static boolean inputLengthBetweenMinAndMax(String userInput, int inputMinLength, int inputMaxLength) {
        int length = userInput.length();
        if (inputMinLength <= length && length <= inputMaxLength) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isAlphabetAndLower(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            char value = userInput.charAt(i);
            if (!('a' <= value && value <= 'z')) {
                return false;
            }
        }
        return true;
    }



}
