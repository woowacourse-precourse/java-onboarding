package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static boolean checkPage(List<Integer> page) {
        return page.get(1) - page.get(0) == 1;
    }

    private static boolean validation(List<Integer> page) {
        if (page.get(0) == 1 || page.get(1) == 400) {
            return false;
        }
        return true;
    }
}