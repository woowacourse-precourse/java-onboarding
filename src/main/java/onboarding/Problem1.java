package onboarding;

import java.util.List;

class Problem1 {
    private static final int FIRST_PAGE_NUMBER = 1;
    private static final int LAST_PAGE_NUMBER = 400;


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static boolean isRightPageRange(Integer leftPage, Integer rightPage) {
        return leftPage > FIRST_PAGE_NUMBER || rightPage < LAST_PAGE_NUMBER;
    }

    private static boolean isValidPageFormat(Integer leftPage, Integer rightPage) {
        return leftPage < rightPage && (rightPage - leftPage) == 1;
    }
}