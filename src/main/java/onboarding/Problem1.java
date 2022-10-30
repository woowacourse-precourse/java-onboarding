package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (validPages(pobi, crong)) {
            return -1;
        }
        return answer;
    }

    private static boolean validPages(List<Integer> pobi, List<Integer> crong) {
        return isFirstPageAndLastPage(pobi, crong);
    }

    private static boolean isFirstPageAndLastPage(List<Integer> pobi, List<Integer> crong) {
        if (pobi.contains(1) || pobi.contains(400)) {
            return true;
        }
        return crong.contains(1) || crong.contains(400);
    }
}
