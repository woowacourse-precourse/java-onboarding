package onboarding;

import java.util.List;

class Problem1 {
    public static final int MIN_PAGES = 1;
    public static final int MAX_PAGES = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (hasCorrectPages(pobi) && hasCorrectPages(crong)) {
            var maxNumPobi = maxSumAndMul(pobi);
            var maxNumCrong = maxSumAndMul(crong);

            if (maxNumPobi == maxNumCrong) {
                return 0;
            }
            return maxNumPobi > maxNumCrong ? 1 : 2;
        }
        return -1;
    }

    private static int maxSumAndMul(List<Integer> pages) {
        int max = Integer.MIN_VALUE;
        for (var page : pages) {
            int sum = 0;
            int mul = 1;
            while (0 < page) {
                int digit = page % 10;
                sum += digit;
                mul *= digit;
                page /= 10;
            }
            max = Integer.max(max, sum);
            max = Integer.max(max, mul);
        }
        return max;
    }

    private static boolean hasCorrectPages(List<Integer> pages) {
        final int leftPage = pages.get(0);
        final int rightPage = pages.get(1);
        final boolean hasInRange = MIN_PAGES <= leftPage && rightPage <= MAX_PAGES;
        final boolean isOddPage = leftPage % 2 == 1;
        final boolean isEvenPage = rightPage % 2 == 0;
        final boolean hasSequential = rightPage - leftPage == 1;

        return hasInRange && isOddPage && isEvenPage && hasSequential;
    }
}