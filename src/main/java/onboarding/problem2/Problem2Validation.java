package onboarding.problem2;

import onboarding.validation.MinMaxInputValidatable;

import java.util.Arrays;
import java.util.List;

import static onboarding.validation.MinMaxIntegerInputValidate.getMinMaxIntegerInputValidate;
import static onboarding.validation.MinMaxStringInputValidate.getMinMaxStringInputValidate;

public class Problem2Validation {
    public static boolean problem2InputValidation(String userInput, int inputMinLength, int inputMaxLength) {
        return inputLengthBetweenMinAndMax(userInput, inputMinLength, inputMaxLength) && isAlphabetAndLower(userInput);
    }

    private static boolean inputLengthBetweenMinAndMax(String userInput, int inputMinLength, int inputMaxLength) {
        MinMaxInputValidatable minMaxInputValidator = getMinMaxStringInputValidate();
        return minMaxInputValidator.isInputBetweenMinAndMax(userInput, inputMinLength, inputMaxLength);
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
