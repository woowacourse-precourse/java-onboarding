package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    public static boolean hasError(List<Integer> pages) {
        if (pages.get(0) <= 0 || pages.get(1) <= 0
                || pages.get(0) >= 401 || pages.get(1) >= 401
                || pages.get(0) + 1 != pages.get(1))
            return true;
        else
            return false;
    }
}