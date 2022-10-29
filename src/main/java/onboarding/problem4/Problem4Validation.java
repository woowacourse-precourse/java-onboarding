package onboarding.problem4;

public class Problem4Validation {
    public static boolean problem4InputValidation(String userInput, int minInput, int maxInput) {
        if (minInput <= userInput.length() && userInput.length() <= maxInput) {
            return true;
        } else {
            return false;
        }
    }
}
