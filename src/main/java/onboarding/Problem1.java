package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (validate(pobi) || validate(crong)) return -1;

        return answer;
    }

    private static boolean validate(List<Integer> pages) {
        if (pages.get(1) - pages.get(0) > 1) return true;
        if (pages.get(1) == 400 || pages.get(0) == 1) return true;

        return false;
    }
}