package onboarding;

import java.util.List;

class Problem1 {

    private static final int CONTINUITY = 1;

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
}