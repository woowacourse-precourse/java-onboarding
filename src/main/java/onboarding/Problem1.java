package onboarding;

import java.util.List;

class Problem1 {
    private static final int LEFT_PAGE_INDEX = 0;
    private static final int RIGHT_PAGE_INDEX = 1;

    private static final int MIN_PAGE_LENGTH = 1;
    private static final int MAX_PAGE_LENGTH = 400;

    private static final int RESULT_EXCEPTION = -1;
    private static final int RESULT_DRAW = 0;
    private static final int RESULT_POBI_WIN = 1;
    private static final int RESULT_CRONG_WIN = 2;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!isValidPages(pobi) || !isValidPages(crong)) {
            return RESULT_EXCEPTION;
        }

        return answer;
    }

    private static boolean isValidPages(List<Integer> pages) {
        Integer leftPage = pages.get(LEFT_PAGE_INDEX);
        Integer rightPage = pages.get(RIGHT_PAGE_INDEX);

        if (!isValidRange(leftPage) || !isValidRange(rightPage)) {
            return false;
        }

        if (!isPageContinuous(leftPage, rightPage)) {
            return false;
        }

        if (!isLeftPage(leftPage) || !isRightPage(rightPage)) {
            return false;
        }

        return true;
    }

    private static boolean isValidRange(Integer page) {
        return MIN_PAGE_LENGTH <= page && page <= MAX_PAGE_LENGTH;
    }

    private static boolean isPageContinuous(Integer leftPage, Integer rightPage) {
        return leftPage + 1 == rightPage;
    }

    private static boolean isLeftPage(Integer page) {
        return page % 2 == 1;
    }

    private static boolean isRightPage(Integer page) {
        return page % 2 == 0;
    }
}
