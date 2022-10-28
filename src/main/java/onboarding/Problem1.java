package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (!isValidPage(pobi) || !isValidPage(crong)) {
            answer = -1;
        }

        return answer;
    }

    private static boolean isValidPage(List<Integer> page) {
        if (page.get(1) - page.get(0) != 1) {
            return false;
        }
        if (page.get(0) % 2 == 0) {
            return false;
        }
        return !page.contains(1) || !page.contains(400);
    }
}