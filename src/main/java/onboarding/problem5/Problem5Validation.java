package onboarding.problem5;

import onboarding.validation.MinMaxInputValidatable;

import static onboarding.validation.MinMaxIntegerInputValidate.getMinMaxIntegerInputValidate;

public class Problem5Validation {
    public static boolean problem5InputValidation(int userInput, int minInput, int maxInput) {
        MinMaxInputValidatable minMaxInputValidator = getMinMaxIntegerInputValidate();
        return minMaxInputValidator.isInputBetweenMinAndMax(userInput, minInput, maxInput);
    }
}
