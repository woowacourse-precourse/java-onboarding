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
        long count = userInput.stream()
                .filter(pageNum -> isBetween(pageNum,bookMin, bookMax))
                .count();
        return Long.valueOf(userInput.size()) == count;
    }

    private static boolean isBetween(Integer pageNum, int bookMin, int bookMax) {
        if (bookMin <= pageNum && pageNum <= bookMax) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isBookNumberContinuous(List<Integer> list) {
        return false;
    }
}
