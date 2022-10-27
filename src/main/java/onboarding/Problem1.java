package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    private static final int MIN_PAGE_NUMBER = 1;
    private static final int MAX_PAGE_NUMBER = 400;
    private static final int DRAW = 0;
    private static final int WIN_POBI = 1;
    private static final int WIN_CRONG = 2;
    private static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isInvalidPages(pobi) || isInvalidPages(crong)) {
            return EXCEPTION;
        }

        int pobiScore = scoreFrom(pobi);
        int crongScore = scoreFrom(crong);
        if (pobiScore == crongScore) {
            return DRAW;
        }
        if (pobiScore > crongScore) {
            return WIN_POBI;
        }
        return WIN_CRONG;
    }

    private static boolean isInvalidPages(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        if (isOutOfRangePage(leftPage) || isOutOfRangePage(rightPage)) {
            return true;
        }

        if (isNotOdd(leftPage) || isNotEven(rightPage)) {
            return true;
        }

        return (rightPage - leftPage) != 1;
    }

    private static boolean isOutOfRangePage(int page) {
        return page < MIN_PAGE_NUMBER || page > MAX_PAGE_NUMBER;
    }

    private static boolean isNotOdd(int number) {
        return number % 2 == 0;
    }

    private static boolean isNotEven(int number) {
        return number % 2 == 1;
    }

    private static int scoreFrom(List<Integer> pages) {
        return pages.stream()
                .map(Problem1::findMaxScore)
                .max(Integer::compareTo).orElse(-1);
    }

    private static int findMaxScore(Integer page) {
        Integer[] digits = pageToDigitNumbers(page);
        return Math.max(addNumbers(digits), multiplyNumbers(digits));
    }

    private static Integer[] pageToDigitNumbers(Integer page) {
        int digit = String.valueOf(page).length();
        Integer[] digitNumbers = new Integer[digit];
        for (int i = 0; i < digit; i++) {
            digitNumbers[i] = page % 10;
            page /= 10;
        }
        return digitNumbers;
    }

    private static int addNumbers(Integer[] digits) {
        return Arrays.stream(digits).reduce(0, Integer::sum);
    }

    private static int multiplyNumbers(Integer[] digits) {
        return Arrays.stream(digits).reduce(1, (integer, integer2) -> integer * integer2);
    }
}
