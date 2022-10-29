package onboarding;

import java.util.List;

class Problem1 {
    private static final int FIRST_PAGE_NUMBER = 1;
    private static final int LAST_PAGE_NUMBER = 400;


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 1. 예외 상황을 처리한다.
        if (checkInvalidPage(pobi) || checkInvalidPage(crong)) {
            return -1;
        }
        return 0;
    }

    private static int findMaxFromOnePage(Integer page) {
        int addMaxNum = 0;
        int multipleMaxNum = 1;

        while ( page > 0) {
            int i = page % 10;
            addMaxNum += i;
            multipleMaxNum *= i;
            page /= 10;
        }
        return Math.max(addMaxNum, multipleMaxNum);
    }

    private static boolean checkInvalidPage(List<Integer> pages) {
        return !isRightPageRange(pages.get(0), pages.get(1)) || !isValidPageFormat(pages.get(0), pages.get(1));
    }

    private static boolean isRightPageRange(Integer leftPage, Integer rightPage) {
        return leftPage > FIRST_PAGE_NUMBER || rightPage < LAST_PAGE_NUMBER;
    }

    private static boolean isValidPageFormat(Integer leftPage, Integer rightPage) {
        return leftPage < rightPage && (rightPage - leftPage) == 1;
    }
}