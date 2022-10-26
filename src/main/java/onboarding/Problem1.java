package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        checkException(pobi);
        checkException(crong);
        answer = getWinner(pobi, crong);
        return answer;
    }

    public static void checkException(List<Integer> pageList) {
    }

    public static int getWinner(List<Integer> pobi, List<Integer> crong) {
        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        if (pobiScore == crongScore) {
            return 0;
        } else if (pobiScore > crongScore) {
            return 1;
        } else {
            return 2;
        }
    }

    public static int getScore(List<Integer> pageList) {
        int add = getMaxDigitSum(pageList);
        int mult = getMaxDigitProduct(pageList);
        return Math.max(add, mult);
    }

    public static int getMaxDigitSum(List<Integer> pageList) {
        int leftDigitSum = getDigitSum(pageList.get(0));
        int rightDigitSum = getDigitSum(pageList.get(1));
        return Math.max(leftDigitSum, rightDigitSum);
    }

    public static int getDigitSum(int page) {
        int digitSum = 0;
        while (page >= 1) {
            digitSum += page % 10;
            page /= 10;
        }
        return digitSum;
    }

    public static int getMaxDigitProduct(List<Integer> pageList) {
        int leftDigitProduct = getDigitProduct(pageList.get(0));
        int rightDigitProduct = getDigitProduct(pageList.get(1));
        return Math.max(leftDigitProduct, rightDigitProduct);
    }

    public static int getDigitProduct(int page) {
        int digitProduct = 1;
        while (page >= 1) {
            digitProduct *= page % 10;
            page /= 10;
        }
        return digitProduct;
    }
}
