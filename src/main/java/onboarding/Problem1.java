package onboarding;

import java.util.List;

class Problem1 {
    private static final int EXCEPTION_CASE = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (!isBoundary(pobi) || !isBoundary(crong)) return EXCEPTION_CASE;
        return answer;
    }

    private static boolean isBoundary(List<Integer> pages) {
        return 3 <= pages.get(0) && pages.get(1) <= 398;
    }
}