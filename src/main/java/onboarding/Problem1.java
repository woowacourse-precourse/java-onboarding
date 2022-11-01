package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {

    private static final int EXCEPTION = -1;
    private static final int DRAW = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int INPUT_LEN = 2;
    private static final int PAGE_MIN = 1;
    private static final int PAGE_MAX = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isInvalidInput(pobi) || isInvalidInput(crong)) {
            return EXCEPTION;
        }
        int pobiScore = computeScore(pobi);
        int crongScore = computeScore(crong);

        return computeMatch(pobiScore, crongScore);
    }

    private static int computeMatch(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return POBI_WIN;
        }
        if (pobiScore < crongScore) {
            return CRONG_WIN;
        }
        return DRAW;
    }

    private static int computeScore(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);
        int leftPageScore = Math.max(plusEachDigit(leftPage), multiplyEachDigit(leftPage));
        int rightPageScore = Math.max(plusEachDigit(rightPage), multiplyEachDigit(rightPage));

        return Math.max(leftPageScore, rightPageScore);
    }

    private static int plusEachDigit(int num) {
        return Arrays.stream(String.valueOf(num)
                .split(""))
            .map(Integer::parseInt)
            .reduce(Integer::sum)
            .orElse(0);
    }

    private static int multiplyEachDigit(int num) {
        return Arrays.stream(String.valueOf(num)
                .split(""))
            .map(Integer::parseInt)
            .reduce((n1, n2) -> n1 * n2)
            .orElse(0);
    }

    private static boolean isInvalidInput(List<Integer> input) {
        if (input.size() != INPUT_LEN) {
            return true;
        }
        int leftPage = input.get(0);
        int rightPage = input.get(1);

        return isInValidPage(leftPage) || isInValidPage(rightPage) || !isOdd(leftPage) || isOdd(rightPage) || leftPage + 1 != rightPage;
    }

    private static boolean isInValidPage(int page) {
        return page < PAGE_MIN || page > PAGE_MAX;
    }

    private static boolean isOdd(int num) {
        return num % 2 == 1;
    }
}