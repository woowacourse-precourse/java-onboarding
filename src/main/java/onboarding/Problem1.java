package onboarding;

import java.util.List;

class Problem1 {
    public static boolean check(int left, int right) {
        if ((1 <= left && left < 400) && (1 < right && right <= 400) && left + 1 == right) return false;
        return true;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}