package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (!checkException(pobi, crong)) return -1;
    }

    private static boolean checkException(List<Integer> pobi, List<Integer> crong) {
        return pobi.get(0) + 1 == pobi.get(1) && crong.get(0) + 1 == crong.get(1);
    }

}