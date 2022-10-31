package onboarding;

import java.util.List;

public class PageValidator {
    private static final int PAGE_COUNT = 2;
    private static final int MIN_PAGE = 1;
    private static final int MAX_PAGE = 400;

    private PageValidator() {
    }

    public static boolean validate(List<Integer> pages) {
        if (pages == null || pages.size() != PAGE_COUNT) {
            return false;
        }
        int left = pages.get(0);
        int right = pages.get(1);
        return isLeftOddAndRightEven(left, right)
                && isContinuous(left, right)
                && inRange(left)
                && inRange(right);
    }

    private static boolean isLeftOddAndRightEven(int left, int right) {
        return left % 2 == 1 && right % 2 == 0;
    }

    private static boolean isContinuous(int left, int right) {
        return left + 1 == right;
    }

    private static boolean inRange(int page) {
        return MIN_PAGE <= page && page <= MAX_PAGE;
    }
}
