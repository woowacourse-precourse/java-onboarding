package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static final int MIN_PAGES = 1;
    public static final int MAX_PAGES = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (hasCorrectPages(pobi) && hasCorrectPages(crong)) {
            var pageDigitsPobi = splitToPageDigits(pobi);
            var pageDigitsCrong = splitToPageDigits(crong);
            var maxNumPobi = maxSumAndMul(pageDigitsPobi);
            var maxNumCrong = maxSumAndMul(pageDigitsCrong);

            if (maxNumPobi == maxNumCrong) {
                return 0;
            }
            return maxNumCrong > maxNumPobi ? 1 : 2;
        }
        return -1;
    }

    private static int maxSumAndMul(List<List<Integer>> pageDigits) {
        var maxSum = pageDigits.stream().mapToInt(
                digits -> digits.stream().reduce(0, (n1, n2) -> n1 + n2)
        ).max().getAsInt();
        var maxMul = pageDigits.stream().mapToInt(
                digits -> digits.stream().reduce(1, (n1, n2) -> n1 * n2)
        ).max().getAsInt();
        return Integer.max(maxSum, maxMul);
    }

    private static List<List<Integer>> splitToPageDigits(List<Integer> pages) {
        return pages.stream().collect(ArrayList::new, Problem1::splitToDigits, List::addAll);
    }

    private static void splitToDigits(List<List<Integer>> pageDigits, Integer page) {
        List<Integer> digits = new ArrayList<>();

        while (0 < page) {
            digits.add(page % 10);
            page /= 10;
        }
        pageDigits.add(digits);
    }

    private static boolean hasCorrectPages(final List<Integer> pages) {
        final int leftPage = pages.get(0);
        final int rightPage = pages.get(1);
        final boolean hasInRange = MIN_PAGES <= leftPage && rightPage <= MAX_PAGES;
        final boolean isOddPage = leftPage % 2 == 1;
        final boolean isEvenPage = rightPage % 2 == 0;
        final boolean hasSequential = rightPage - leftPage == 1;

        return hasInRange && isOddPage && isEvenPage && hasSequential;
    }
}