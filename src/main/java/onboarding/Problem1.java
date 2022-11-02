package onboarding;

import java.util.List;

class Problem1 {

    static boolean isVaild(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        if (rightPage - leftPage != 1)
            return false;
        if (leftPage < 3 || leftPage > 397) {
            return false;
        }
        return leftPage % 2 == 1;
    }

    static int addCalc(int page) {
        int divisor = 100;
        int result = 0;
        while (divisor > 0) {
            result += (int) (page / divisor);
            page %= divisor;
            divisor /= 10;
        }
        return result;
    }

    static int multiplyCalc(int page) {
        int divisor = 100;
        int result = 1;
        if (page >= 10 && page < 100) {
            divisor = 10;
        } else if (page < 10) {
            divisor = 1;
        }
        while (divisor > 0) {
            result *= (int) (page / divisor);
            page %= divisor;
            divisor /= 10;
        }
        return result;
    }

    static int calcMaxScore(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);
        int maxScore = 0;

        maxScore = Math.max(maxScore, addCalc(leftPage));
        maxScore = Math.max(maxScore, addCalc(rightPage));
        maxScore = Math.max(maxScore, multiplyCalc(leftPage));
        maxScore = Math.max(maxScore, multiplyCalc(rightPage));

        return maxScore;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isVaild(pobi) || !isVaild(crong)) {
            return -1;
        }
        int pobi_score = calcMaxScore(pobi);
        int crong_score = calcMaxScore(crong);

        if (pobi_score > crong_score)
            return 1;
        if (pobi_score < crong_score)
            return 2;
        return 0;
    }
}