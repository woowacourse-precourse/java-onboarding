package onboarding;

import java.util.List;

class Problem1 {

    private static final int CONTINUITY = 1;
    private static final int PAGE_MIN = 1;
    private static final int PAGE_MAX = 400;
    private static final int VALID_ERROR = -1;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int DRAW = 0;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (!(checkPageContinuity(pobi) && checkPageContinuity(crong) && checkPageValidation(pobi)
            && checkPageValidation(crong))) {
            return VALID_ERROR;
        }
        int pobiMaxScore = pageMaxScore(pobi);
        int crongMaxScore = pageMaxScore(crong);
        if (pobiMaxScore > crongMaxScore) {
            answer = POBI_WIN;
        } else if (pobiMaxScore < crongMaxScore) {
            answer = CRONG_WIN;
        } else if (pobiMaxScore == crongMaxScore) {
            answer = DRAW;
        }
        return answer;
    }

    public static boolean checkPageContinuity(List<Integer> page) {
        if (page.get(1) - page.get(0) == CONTINUITY) {
            return true;
        }
        return false;
    }

    public static boolean checkPageValidation(List<Integer> page) {
        if (PAGE_MIN <= page.get(0) && page.get(0) <= PAGE_MAX && PAGE_MIN <= page.get(1)
            && page.get(1) <= PAGE_MAX) {
            return true;
        }
        return false;
    }

    public static int pageSum(Integer page) {
        int pageSum = 0;
        Integer pageCheck = page;
        while (pageCheck != 0) {
            pageSum += pageCheck % 10;
            pageCheck = pageCheck / 10;
        }
        return pageSum;
    }

    public static int pageMultiply(Integer page) {
        int pageMultiply = 1;
        Integer pageCheck = page;
        while (pageCheck != 0) {
            pageMultiply *= pageCheck % 10;
            pageCheck = pageCheck / 10;
        }
        return pageMultiply;
    }

    public static int pageMaxScore(List<Integer> page) {
        int pageSumMax = Math.max(pageSum(page.get(0)), pageSum(page.get(1)));
        int pageMultiplyMax = Math.max(pageMultiply(page.get(0)), pageMultiply(page.get(1)));
        return Math.max(pageSumMax, pageMultiplyMax);
    }
}