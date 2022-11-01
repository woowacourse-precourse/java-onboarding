package onboarding;

import java.util.List;

class Problem1 {
    private static final int EXCEPTION = -1;
    private static final int DRAW = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int LEFT = 0;
    private static final int RIGHT = 1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isBoundary(pobi) || !isBoundary(crong)) {
            return EXCEPTION;
        }
        if (!isContinuous(pobi) || !isContinuous(crong)) {
            return EXCEPTION;
        }
        return compareScore(calculateScore(pobi), calculateScore(crong));
    }

    private static boolean isBoundary(List<Integer> pages) {
        return 3 <= pages.get(LEFT) && pages.get(RIGHT) <= 398;
    }

    private static boolean isContinuous(List<Integer> pages) {
        return pages.get(LEFT) + 1 == pages.get(RIGHT);
    }

    private static int calculateScore(List<Integer> pages) {
        return Math.max(getPageScore(pages.get(LEFT)), getPageScore(pages.get(RIGHT)));
    }

    private static int getPageScore(int page) {
        return Math.max(sumDigits(page), productDigits(page));
    }

    private static int sumDigits(int page) {
        return String.valueOf(page)
                .chars()
                .map(Character::getNumericValue)
                .sum();
    }

    private static int productDigits(int page) {
        return String.valueOf(page)
                .chars()
                .map(Character::getNumericValue)
                .reduce(1, (a, b) -> a * b);
    }

    private static int compareScore(int pobiScore, int crongScore) {
        if (crongScore > pobiScore) {
            return CRONG_WIN;
        }
        if (crongScore < pobiScore) {
            return POBI_WIN;
        }
        return DRAW;
    }
}