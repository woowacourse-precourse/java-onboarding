package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isInputInvalid(pobi) || isInputInvalid(crong))
            return -1;

        int pobiScore = calculateScore(pobi);
        int crongScore = calculateScore(crong);

        if (pobiScore == crongScore)
            return 0;

        if (pobiScore > crongScore)
            return 1;
        return 2;
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
    private static int calculateScore(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        int score = 0;
        score = Math.max(score, addDigits(leftPage));
        score = Math.max(score, addDigits(rightPage));
        score = Math.max(score, multiplyDigits(leftPage));
        score = Math.max(score, multiplyDigits(rightPage));
        return score;
    }
    private static int addDigits(int page) {
        int score = 0;
        while (page > 0) {
            score += page % 10;
            page /= 10;
        }
        return score;
    }
    private static int multiplyDigits(int page) {
        int score = 1;
        while (page > 0) {
            score *= page % 10;
            page /= 10;
        }
        return score;
    }
}