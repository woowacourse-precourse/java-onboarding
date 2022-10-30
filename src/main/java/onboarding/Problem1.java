package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 예외
        if (pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)) {
            // 페이지 번호가 연속되지 않는 경우
            return -1;
        }

        return Integer.MAX_VALUE;
    }
}