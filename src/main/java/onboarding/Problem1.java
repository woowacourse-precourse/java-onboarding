package onboarding;

import java.util.List;

class Problem1 {
    private static final int EXCEPTION = -1;
    private static final int DRAW = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int FIRST_PAGE = 1;
    private static final int LAST_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isNotValidPage(pobi) || isNotValidPage(crong)) {
            return EXCEPTION;
        }
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    private static boolean isNotValidPage(List<Integer> pages) {
        if (!isValidSize(pages) || !isValidRange(pages)) {
            return true;
        }

        if (!isValidOddEven(pages) || !isValidInterval(pages)) {
            return true;
        }
        return false;
    }

    private static boolean isValidRange(List<Integer> pages) {
        boolean checker = true;

        for (int page : pages) {
            checker = checker && isContained(page);
        }
        if (checker) {
            return true;
        }
        return false;
    }
    private static boolean isValidSize(List<Integer> pages) {
        return pages.size() == 2;
    }
    private static boolean isContained(int page) {
        return FIRST_PAGE < page && page < LAST_PAGE;
    }

    private static boolean isValidOddEven(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        if (leftPage % 2 == 0 || rightPage % 2 == 1) {
            return false;
        }
        return true;
    }

    private static boolean isValidInterval(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        return rightPage - leftPage == 1;
    }
}