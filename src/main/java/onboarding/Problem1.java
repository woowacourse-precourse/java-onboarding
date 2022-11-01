package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!isValid(pobi) || !isValid(crong)) {
            answer = -1;
        }

        return answer;
    }

    private static boolean isValid(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        if (leftPage <= 1 || rightPage >= 400 || leftPage + 1 != rightPage) {
            return false;
        }
        return true;
    }
}

