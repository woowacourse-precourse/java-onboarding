package onboarding.problem1;

import java.util.List;

public class Validation {
    private static final int START_RIGHT_PAGE = 2;
    private static final int END_RIGHT_PAGE = 400;

    public static boolean isValidPage(List<Integer> list) {
        boolean result = true;

        Integer left = list.get(0);
        Integer right = list.get(1);

        for (Integer integer : list) {
            result = (isPositiveNumber(integer) && !isPageBothEnds(integer));
        }

        if (!isOdd(left) || !isEven(right) || !isContinuousNumber(left, right)) {
            result = false;
        }

        return result;
    }

    private static boolean isPositiveNumber(Integer integer) {
        return integer > 0;
    }

    private static boolean isPageBothEnds(Integer integer) {
        return integer <= START_RIGHT_PAGE || integer >= END_RIGHT_PAGE;
    }

    private static boolean isOdd(Integer integer) {
        return integer % 2 != 0;
    }

    private static boolean isEven(Integer integer) {
        return integer % 2 == 0;
    }

    private static boolean isContinuousNumber(Integer left, Integer right) {
        return left == right - 1;
    }
}
