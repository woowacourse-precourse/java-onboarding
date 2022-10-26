package onboarding;

import java.util.List;

import static java.lang.Math.max;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (validatePages(pobi) & validatePages(crong)) {
            int pobiMax = getMaxScore(pobi);
            int crongMax = getMaxScore(crong);
            answer = pobiMax > crongMax ? 1 : crongMax > pobiMax ? 2 : 0;
        } else {
            answer = -1;
        }
        return answer;
    }
    private static int getMaxScore(List<Integer> pages) {
        int leftPageNumber = pages.get(0);
        int rightPageNumber = pages.get(1);
        int maxDigitSum = max(getDigitSum(leftPageNumber), getDigitSum(rightPageNumber));
        int maxDigitProduct = max(getDigitProduct(leftPageNumber), getDigitProduct(rightPageNumber));
        return max(maxDigitSum, maxDigitProduct);
    }
    private static int getDigitSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    private static int getDigitProduct(int n) {
        int product = 1;
        while (n != 0) {
            product *= n % 10;
            n /= 10;
        }
        return product;
    }

    private static boolean validatePages(List<Integer> pages) {
        //TODO: implement validity conditions
        return true;
    }
}