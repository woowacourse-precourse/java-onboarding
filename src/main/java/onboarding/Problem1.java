package onboarding;

import java.util.List;

class Problem1 {
    private static final String PAGE_SIZE_EXCEPTION_MSG = "there are not 2 pages";
    private static final String PAGE_OUT_BOUND_EXCEPTION_MSG = "page is out of bound";
    private static final String INVALID_PAGE_GAP_EXCEPTION_MSG = "page gap is invalid";
    private static final String INVALID_PAGE_ORDER_EXCEPTION_MSG = "page order is invalid";
    private static final int LEFT_PAGE_LOWER_BOUND = 1;
    private static final int LEFT_PAGE_UPPER_BOUND = 399;
    private static final int RIGHT_PAGE_LOWER_BOUND = 2;
    private static final int RIGHT_PAGE_UPPER_BOUND = 400;

    private static final int GAME_POBI = 1;
    private static final int GAME_CRONG = 2;
    private static final int GAME_DRAW = 0;
    private static final int GAME_EXCEPTION = -1;


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;
        try {
            checkPages(pobi);
            checkPages(crong);
            int pobiScore = getScore(pobi);
            int crongScore = getScore(crong);
            answer = whoIsWinner(pobiScore, crongScore);
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
        if (leftPage >= LEFT_PAGE_LOWER_BOUND && leftPage <= LEFT_PAGE_UPPER_BOUND) {
            return;
        }
        throw new RuntimeException(PAGE_OUT_BOUND_EXCEPTION_MSG);
    }

    private static void checkRightPageBound(int rightPage) {
        if (rightPage >= RIGHT_PAGE_LOWER_BOUND && rightPage <= RIGHT_PAGE_UPPER_BOUND) {
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

    private static int getScore(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);
        int leftPageSum = getBiggerSum(leftPage);
        int rightPageSum = getBiggerSum(rightPage);

        return leftPageSum > rightPageSum ? leftPageSum : rightPageSum;
    }

    private static int getBiggerSum(int page) {
        int addSum = 0;
        int mulSum = 1;
        int digit;

        while (page > 0) {
            digit = page % 10;
            addSum += digit;
            mulSum *= digit;
            page = page / 10;
        }

        return addSum > mulSum ? addSum : mulSum;
    }

    private static int whoIsWinner(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return GAME_POBI;
        }
        if (pobiScore < crongScore) {
            return GAME_CRONG;
        }
        return GAME_DRAW;
    }
}