package onboarding;

import java.util.List;

import static java.lang.Math.max;

class Problem1 {

    private final static int POBI_WIN = 1;
    private final static int CRONG_WIN = 2;
    private final static int DRAW = 0;
    private final static int EXCEPTION = -1;
    private final static int START_PAGE_NUMBER = 1;
    private final static int END_PAGE_NUMBER = 400;
    private final static int PAGE_GAP = 1;
    private final static int PAGE_LIST_SIZE = 2;
    
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isInvalidPage(pobi) || isInvalidPage(crong)) {
            return EXCEPTION;
        }

        final int pobiScore = getUserScore(pobi);
        final int crongScore = getUserScore(crong);

        return getWinner(pobiScore, crongScore);
    }

    private static int getWinner(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return POBI_WIN;
        }
        if (crongScore > pobiScore) {
            return CRONG_WIN;
        }
        return DRAW;
    }

    private static int getUserScore(List<Integer> user) {
        return max(
                getMaxInListWithCalculator(user, addEachDigitCalculator()),
                getMaxInListWithCalculator(user, multiplyEachDigitCalculator())
        );
    }

    private static int getMaxInListWithCalculator(List<Integer> pages, IntCalculate calculator) {
        return pages.stream()
                .mapToInt(calculator::calculate)
                .max()
                .getAsInt();
    }

    @FunctionalInterface
    private interface IntCalculate {
        int calculate(int number);
    }

    private static IntCalculate addEachDigitCalculator() {
        return (int number) -> {
            int ret = 0;
            while (number != 0) {
                ret += (number % 10);
                number /= 10;
            }
            return ret;
        };
    }

    private static IntCalculate multiplyEachDigitCalculator() {
        return (int number) -> {
            int ret = 1;
            while (number != 0) {
                ret *= (number % 10);
                number /= 10;
            }
            return ret;
        };
    }

    private static boolean isInvalidPage(List<Integer> page) {
        return isNotValidPageSize(page) ||
                hasFirstOrLastPage(page) ||
                isNotSequencePages(page) ||
                isEven(page.get(0)) ||
                isOdd(page.get(1));
    }

    private static boolean isNotValidPageSize(List<Integer> pages) {
        return pages.size() != PAGE_LIST_SIZE;
    }

    private static boolean hasFirstOrLastPage(List<Integer> pages) {
        return pages.stream().anyMatch(page -> page == START_PAGE_NUMBER | page == END_PAGE_NUMBER);
    }

    private static boolean isNotSequencePages(List<Integer> pages) {
        return pages.get(0) + PAGE_GAP != pages.get(1);
    }

    private static boolean isOdd(int page) {
        return page % 2 == 1;
    }

    private static boolean isEven(int page) {
        return page % 2 == 0;
    }
}