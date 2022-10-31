package onboarding;

import java.lang.reflect.Field;
import java.util.List;

class Problem1 {
    private static final int FIRST_PAGE = 1;
    private static final int LAST_PAGE = 400;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int DRAW = 0;
    private static final int DIGIT_DIVISOR = 10;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isInvalidPages(pobi) || isInvalidPages(crong)) {
            return -1;
        }

        int pobiResult = getResult(pobi);
        int crongResult = getResult(crong);

        return getWinner(pobiResult, crongResult);
    }

    private static boolean isInvalidPages(List<Integer> pages) {
        return pages.get(0) < FIRST_PAGE || pages.get(1) > LAST_PAGE
                || pages.get(1) - pages.get(0) != 1 || pages.get(0) % 2 == 0 || pages.get(1) % 2 == 1;
    }

    private static int getResult(List<Integer> pages) {
        int leftPageScore = Math.max(getSumOfEachPages(pages.get(0)),getMulOfEachPages(pages.get(0)));
        int rightPageScore = Math.max(getSumOfEachPages(pages.get(1)),getMulOfEachPages(pages.get(1)));

        return Math.max(leftPageScore, rightPageScore);
    }

    private static int getSumOfEachPages(int page) {
        int sum = 0;
        int num = page;

        while (num != 0) {
            sum += num % DIGIT_DIVISOR;
            num /= DIGIT_DIVISOR;
        }

        return sum;
    }

    private static int getMulOfEachPages(int page) {
        int mul = 1;
        int num = page;

        while (num != 0) {
            mul *= num % DIGIT_DIVISOR;
            num /= DIGIT_DIVISOR;
        }

        return mul;
    }

    private static int getWinner(int pobiResult, int crongResult) {
        if (pobiResult > crongResult) {
            return POBI_WIN;
        }

        if (pobiResult < crongResult) {
            return CRONG_WIN;
        }

        return DRAW;
    }
}