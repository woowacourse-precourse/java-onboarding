package onboarding;

import java.util.List;
import java.util.Map;

class Problem1 {

    static boolean isVaild(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);
        if (rightPage - leftPage != -1)
            return false;

        if (leftPage >= 3 && leftPage <= 397) {
            return leftPage % 2 == 1;
        } else {
            return false;
        }
    }

    static int addCalc(List<Integer> pages) {
        int maxResult = 0;
        for (int page : pages) {
            int divisor = 100;
            int result = 0;
            while (divisor > 0) {
                result += (int) (page / divisor);
                page %= divisor;
                divisor /= 10;
            }
            maxResult = Math.max(maxResult, result);
        }
        return maxResult;
    }

    static int multiplyCalc(List<Integer> pages) {
        int maxResult = 0;
        for (int page : pages) {
            int divisor = 100;
            if (page >= 10 && page < 100) {
                divisor = 10;
            } else if (page < 10) {
                divisor = 1;
            }
            int result = 1;
            while (divisor > 0) {
                result *= (int) (page / divisor);
                page %= divisor;
                divisor /= 10;
            }
            maxResult = Math.max(maxResult, result);
        }
        return maxResult;
    }

    static int maxScore(List<Integer> pages) {
        int addScore = addCalc(pages);
        int multiplyScore = multiplyCalc(pages);
        return Math.max(addScore, multiplyScore);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isVaild(pobi) || !isVaild(crong)) {
            return -1;
        }
        int pobi_score = maxScore(pobi);
        int crong_score = maxScore(crong);

        if (pobi_score > crong_score) {
            return 1;
        } else if (pobi_score < crong_score) {
            return 2;
        } else {
            return 0;
        }
    }
}