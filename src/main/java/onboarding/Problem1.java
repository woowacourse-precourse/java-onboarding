package onboarding;

import java.util.List;

import static java.lang.Math.max;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isException(pobi) || isException(crong)) {
            return -1;
        }

        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        return winner(pobiScore, crongScore);
    }

    private static boolean isException(List<Integer> pages) {
        return isNotValidPages(pages) || isBreakRule(pages);
    }

    private static boolean isNotValidPages(List<Integer> pages) {
        return pages.get(1) - pages.get(0) != 1;
    }

    private static boolean isBreakRule(List<Integer> pages) {
        return pages.get(0) <= 1 || pages.get(1) >= 400;
    }

    private static int winner(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return 1;
        }

        if (pobiScore < crongScore) {
            return 2;
        }

        return 0;
    }

    private static int getScore(List<Integer> pages) {
        int score = 0;

        for (int page : pages) {
            int max = max(add(page), multiply(page));

            if (score < max) {
                score = max;
            }
        }

        return score;
    }

    private static int multiply(int num) {
        int result = 1;

        while (num > 0) {
            result *= num % 10;
            num /= 10;
        }

        return result;
    }

    private static int add(int num) {
        int result = 0;

        while (num > 0) {
            result += num % 10;
            num /= 10;
        }

        return result;
    }
}
