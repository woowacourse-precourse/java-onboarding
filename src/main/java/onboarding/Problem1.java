package onboarding;

import java.util.List;

class Problem1 {

    /**
     * 두 페이지 수가 연속되었는지 확인한다.
     * @param input
     * @return
     */
    private static boolean isException(List<Integer> input) {
        if (input.get(0) % 2 != 1 || input.get(1) % 2 != 0) return true;
        if (input.get(1) - input.get(0) != 1) return true;
        if (input.get(0) <= 1 || input.get(1) >= 400) return true;
        return false;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}