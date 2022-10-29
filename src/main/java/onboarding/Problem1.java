package onboarding;

import java.util.List;

class Problem1 {

    private static final int CONTINUITY = 1;
    private static final int PAGE_MIN = 1;
    private static final int PAGE_MAX = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
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
}