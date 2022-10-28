package onboarding.problem1Validation;

import java.util.List;

import static java.lang.Math.*;

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

    public static boolean isBookNumberContinuous(List<Integer> list) {
        int abs = abs(list.get(0) - list.get(1));
        if (abs == 1) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean isBookNumberOddEvenPair(List<Integer> list) {
        if ((list.get(0) % 2 == 1) && (list.get(1) % 2 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isFirstAddOneEqualsSecondValue(List<Integer> list) {
        if (list.get(0) + 1 == list.get(1)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isBetween(Integer pageNum, int bookMin, int bookMax) {
        if (bookMin <= pageNum && pageNum <= bookMax) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean problem1InputValidation(List<Integer> list, int userInputLength, int bookMin, int bookMax) {
        return userInputSizeEquals(list, userInputLength)
                && isBookNumberBetweenMinAndMax(list, bookMin, bookMax)
                && isBookNumberContinuous(list)
                && isBookNumberOddEvenPair(list)
                &&isFirstAddOneEqualsSecondValue(list);
    }
}
