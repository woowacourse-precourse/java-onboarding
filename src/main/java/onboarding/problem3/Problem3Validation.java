package onboarding.problem3;

import onboarding.validation.MinMaxInputValidatable;

import static onboarding.validation.MinMaxIntegerInputValidate.getMinMaxIntegerInputValidate;

public class Problem3Validation {
    public static boolean problem3InputValidation(int userInput, int minInput, int maxInput) {
        MinMaxInputValidatable minMaxInputValidator = getMinMaxIntegerInputValidate();
        return minMaxInputValidator.isInputBetweenMinAndMax(userInput, minInput, maxInput);
    }
}
