package onboarding.problem4;

import onboarding.validation.MinMaxInputValidatable;

import static onboarding.validation.MinMaxIntegerInputValidate.getMinMaxIntegerInputValidate;
import static onboarding.validation.MinMaxStringInputValidate.getMinMaxStringInputValidate;

public class Problem4Validation {
    public static boolean problem4InputValidation(String userInput, int minInput, int maxInput) {
        MinMaxInputValidatable minMaxInputValidator = getMinMaxStringInputValidate();
        return minMaxInputValidator.isInputBetweenMinAndMax(userInput, minInput, maxInput);
    }
}
