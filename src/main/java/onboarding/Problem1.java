package onboarding;

import java.util.List;

class Problem1 {
    private static final String PAGE_SIZE_EXCEPTION_MSG = "there are not 2 pages";
    private static final String PAGE_OUT_BOUND_EXCEPTION_MSG = "page is out of bound";
    private static final String INVALID_PAGE_GAP_EXCEPTION_MSG = "page gap is invalid";
    private static final String INVALID_PAGE_ORDER_EXCEPTION_MSG = "page order is invalid";

    private static final int GAME_EXCEPTION = 2;
    private static final int leftPageLowerBound = 1;
    private static final int leftPageUpperBound = 399;
    private static final int rightPageLowerBound = 2;
    private static final int rightPageUpperBound = 400;


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        try {
            checkPages(pobi);
            checkPages(crong);
        } catch (RuntimeException e) {
            answer = GAME_EXCEPTION;
        }

        return answer;
    }

    private static void checkPages(List<Integer> pages) {
        checkPagesSize(pages);
        checkPageOrder(pages);
        checkPageGap(pages);
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);
        checkLeftPageBound(leftPage);
        checkRightPageBound(rightPage);
        checkOddPage(leftPage);
        checkEvenPage(rightPage);
    }

    private static void checkPagesSize(List<Integer> pages) {
        if (pages == null || pages.size() != 2) {
            throw new RuntimeException(PAGE_SIZE_EXCEPTION_MSG);
        }
    }

    private static void checkPageOrder(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        if (leftPage < rightPage) {
            return;
        }
        throw new RuntimeException(INVALID_PAGE_ORDER_EXCEPTION_MSG);
    }

    private static void checkPageGap(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        if (Math.abs(rightPage - leftPage) == 1) {
            return;
        }
        throw new RuntimeException(INVALID_PAGE_GAP_EXCEPTION_MSG);
    }

    private static void checkLeftPageBound(int leftPage) {
        if (leftPage >= leftPageLowerBound && leftPage <= leftPageUpperBound) {
            return;
        }
        throw new RuntimeException(PAGE_OUT_BOUND_EXCEPTION_MSG);
    }

    private static void checkRightPageBound(int rightPage) {
        if (rightPage >= rightPageLowerBound && rightPage <= rightPageUpperBound) {
            return;
        }
        throw new RuntimeException(PAGE_OUT_BOUND_EXCEPTION_MSG);
    }

    private static void checkOddPage(int leftPage) {
        if (leftPage % 2 == 1) {
            return;
        }
        throw new RuntimeException(INVALID_PAGE_GAP_EXCEPTION_MSG);
    }

    private static void checkEvenPage(int rightPage) {
        if (rightPage % 2 == 0) {
            return;
        }
        throw new RuntimeException(INVALID_PAGE_GAP_EXCEPTION_MSG);
    }
}