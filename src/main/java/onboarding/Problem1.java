package onboarding;

import java.util.List;

class Problem1 {

    private static final int MIN_PAGE = 1;
    private static final int MAX_PAGE = 400;

    private static final int LEFT_PAGE_INDEX = 0;
    private static final int RIGHT_PAGE_INDEX = 1;

    private static final int EXCEPTION_CASE = -1;


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (isValidPages(pobi) && isValidPages(crong)) {

            answer = 0;
        } else {
            answer = EXCEPTION_CASE;
        }

        return answer;
    }

    private static boolean isValidPages(List<Integer> pages) {
        Integer leftPage = pages.get(LEFT_PAGE_INDEX);
        Integer rightPage = pages.get(RIGHT_PAGE_INDEX);

        if ((isOutOfRange(leftPage) || isOutOfRange(rightPage))) {
            return false;
        }

        if (!isOdd(leftPage) || !isEven(rightPage)) {
            return false;
        }

        if (!isContinuousNumber(leftPage, rightPage)) {
            return false;
        }

        return true;
    }

    private static boolean isOutOfRange(int page) {
        if (page < MIN_PAGE || page > MAX_PAGE) {
            return true;
        }

        return false;
    }

    private static boolean isOdd(int page) {
        return page % 2 == 1;
    }

    private static boolean isEven(int page) {
        return page % 2 == 0;
    }

    private static boolean isContinuousNumber(int a, int b) {
        return b - a == 1;
    }
}