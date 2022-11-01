package onboarding.problem1;

import java.util.List;

public class Validator {
    private static final int START_PAGE = 1;
    private static final int END_PAGE = 400;

    public static boolean validate(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        if (checkRangeError(leftPage, rightPage)) {return false;}

        if (checkEvenOddError(leftPage, rightPage)) {return false;}

        return checkContinuousError(leftPage, rightPage);
    }

    private static boolean checkContinuousError(int leftPage, int rightPage) {
        return leftPage - rightPage != -1;
    }

    private static boolean checkEvenOddError(int leftPage, int rightPage) {
        return !((leftPage % 2 == 1) && (rightPage % 2 == 0));
    }

    private static boolean checkRangeError(int leftPage, int rightPage) {
        return !(isInRange(leftPage) && isInRange(rightPage));
    }

    public static boolean isInRange(int page) {
        return (page >= START_PAGE) && (page <= END_PAGE);
    }
}
