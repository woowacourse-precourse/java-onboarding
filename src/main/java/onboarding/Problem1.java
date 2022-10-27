package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    // 시작면 or 마지막면이 나오는 경우
    public static boolean isFirstOrLast(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(0) == 1 || crong.get(0) == 1 || pobi.get(1) == 400 || crong.get(1) == 400) {
            return true;
        }
        return false;
    }
}