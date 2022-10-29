package onboarding;

import java.util.List;

class Problem1 {
    private static final int EXCEPTION_CASE = -1;
    private static final int DRAW = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isBoundary(pobi) || !isBoundary(crong)) {
            return EXCEPTION_CASE;
        }
        if (!isContinue(pobi) || !isContinue(crong)) {
            return EXCEPTION_CASE;
        }
        return compareScore(calculateScore(pobi), calculateScore(crong));
    }

    private static int compareScore(int pobiScore, int crongScore) {
        if (crongScore > pobiScore) {
            return CRONG_WIN;
        } else if (crongScore < pobiScore) {
            return POBI_WIN;
        } else {
            return DRAW;
        }
    }

    private static int calculateScore(List<Integer> pages) {
        return Math.max(getPageScore(pages.get(0)), getPageScore(pages.get(1)));
    }

    private static int getPageScore(int page) {
        return Math.max(sumDigits(page), productDigits(page));
    }

    private static int sumDigits(int page) {
        int sum = 0;
        String pageStr = Integer.toString(page);
        for (int i = 0; i < pageStr.length(); i++) {
            sum += pageStr.charAt(i) - '0';
        }
        return sum;
    }

    private static int productDigits(int page) {
        int result = 1;
        String pageStr = Integer.toString(page);
        for (int i = 0; i < pageStr.length(); i++) {
            result *= pageStr.charAt(i) - '0';
        }
        return result;
    }

    private static boolean isBoundary(List<Integer> pages) {
        return 3 <= pages.get(0) && pages.get(1) <= 398;
    }

    private static boolean isContinue(List<Integer> pages) {
        return pages.get(0) + 1 == pages.get(1);
    }
}