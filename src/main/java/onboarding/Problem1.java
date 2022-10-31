package onboarding;

import java.util.List;
import java.util.function.BiFunction;

class Problem1 {
    private static final int DRAW = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (validationPages(pobi) || validationPages(crong)) {
            return EXCEPTION;
        }
        int pobiMaxValue = getMaxValue(pobi);
        int crongMaxValue = getMaxValue(crong);

        if (pobiMaxValue > crongMaxValue) {
            return POBI_WIN;
        }
        if (crongMaxValue > pobiMaxValue) {
            return CRONG_WIN;
        }
        return DRAW;
    }

    private static boolean validationPages(List<Integer> pages) {
        return pages.get(0) + 1 != pages.get(1);
    }

    private static int getMaxValue(List<Integer> pages) {
        int max = 0;
        for (int page : pages) {
            String[] p = String.valueOf(page).split("");
            max = Math.max(max, getMaxBetweenSumAndMul(p));
        }
        return max;
    }

    private static int getMaxBetweenSumAndMul(String[] page) {
        return Math.max(
                calculation(page, (first, second) -> first + second),
                calculation(page, (first, second) -> first * second)
        );
    }

    private static int calculation(String[] page, BiFunction<Integer, Integer, Integer> function) {
        int result = Integer.parseInt(page[0]);
        for (int i = 1; i < page.length; i++) {
            result = function.apply(result, Integer.valueOf(page[i]));
        }
        return result;
    }
}