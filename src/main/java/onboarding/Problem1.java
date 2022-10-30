package onboarding;

import java.util.List;

class Problem1 {
    private static boolean isException(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(0) != pobi.get(1) - 1 || crong.get(0) != crong.get(1) - 1) {
            return true;
        }
        if (pobi.get(0) == 1 || crong.get(0) == 1 || pobi.get(1) == 400 || crong.get(1) == 400) {
            return true;
        }
        return false;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (isException(pobi, crong)) {
            answer = -1;
            return answer;
        }
        return answer;
    }
}