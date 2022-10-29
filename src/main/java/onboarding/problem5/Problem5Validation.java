package onboarding.problem5;

public class Problem5Validation {
    public static boolean problem5InputValidation(int userInput, int minInput, int maxInput) {
        if (minInput <= userInput && userInput <= maxInput) {
            return true;
        } else {
            return false;
        }
    }
}
