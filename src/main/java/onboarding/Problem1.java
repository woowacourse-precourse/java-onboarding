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
        if (isNotPairPages(pobi, crong)) {
            return true;
        }
        return isFirstPageAndLastPage(pobi, crong);
    }

    private static boolean isNotPairPages(List<Integer> pobi, List<Integer> crong) {
        return pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1;
    }

    private static boolean isFirstPageAndLastPage(List<Integer> pobi, List<Integer> crong) {
        if (pobi.contains(1) || pobi.contains(400)) {
            return true;
        }
        return crong.contains(1) || crong.contains(400);
    }
}
