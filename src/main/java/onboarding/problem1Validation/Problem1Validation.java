package onboarding.problem1Validation;

import java.util.List;

public class Problem1Validation {
    public static boolean userInputSizeEquals(List<Integer> userInput, int listSize) {
        if (userInput.size() == 2) {
            return true;
        }
        return false;
    }

    public static boolean isBookNumberBetweenMinAndMax(List<Integer> userInput, int bookMin, int bookMax) {
        return false;
    }
}
