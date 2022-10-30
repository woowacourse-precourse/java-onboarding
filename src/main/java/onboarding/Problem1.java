package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isInputInvalid(pobi) || isInputInvalid(crong))
            return -1;

        int answer = Integer.MAX_VALUE;
        return answer;
    }
    private static boolean isInputInvalid(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        if (leftPage % 2 == 0)
            return true;

        if (leftPage < 1 || 399 < leftPage)
            return true;

        return leftPage + 1 != rightPage;
    }
    private static int addDigits(int page) {
        int score = 0;
        while (page > 0) {
            score += page % 10;
            page /= 10;
        }
        return score;
    }
}