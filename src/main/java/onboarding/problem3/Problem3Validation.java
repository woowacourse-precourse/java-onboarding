package onboarding.problem3;

public class Problem3Validation {
    public static boolean problem3InputValidation(int userInput, int minInput, int maxInput) {
        if (minInput <= userInput && userInput <= maxInput) {
            return true;
        } else {
            return false;
        }
    }
}
