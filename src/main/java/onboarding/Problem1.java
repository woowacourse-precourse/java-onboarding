package onboarding;

import java.util.List;

class Problem1 {
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int DRAW = 0;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (exceptional(pobi, crong)) {
            return -1;
        }
        int pobiScore = maxScore(pobi);
        int crongScore = maxScore(crong);

        if (pobiScore > crongScore) {
            return POBI_WIN;
        }
        if (pobiScore < crongScore) {
            return CRONG_WIN;
        }
        return DRAW;
    }

    private static boolean exceptional(List<Integer> pobi, List<Integer> crong) {
        return !PageValidator.validate(pobi) || !PageValidator.validate(crong);
    }

    private static int maxScore(List<Integer> pages) {
        int left = pages.get(0);
        int right = pages.get(1);
        return Math.max(maxScore(left), maxScore(right));
    }

    private static int maxScore(int page) {
        int sum = sum(page);
        int product = multiply(page);
        return Math.max(sum, product);
    }

    private static int sum(int page) {
        int sum = 0;
        while (page > 0) {
            sum += page % 10;
            page /= 10;
        }
        return sum;
    }

    private static int multiply(int page) {
        int product = 1;
        while (page > 0) {
            product *= page % 10;
            page /= 10;
        }
        return product;
    }
}
