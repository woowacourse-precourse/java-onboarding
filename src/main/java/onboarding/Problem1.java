package onboarding;

import java.util.List;

class Problem1 {

    private static final int START_PAGE = 1;
    private static final int END_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            checkException(pobi);
            checkException(crong);
        } catch (IllegalStateException e) {
            return -1;
        }
        return getWinner(pobi, crong);
    }

    public static void checkException(List<Integer> pageList) throws IllegalStateException {
        checkPageHasAscending1Difference(pageList);
        checkListInGivenRange(pageList);
        checkLeftPageIsOdd(pageList);
    }

    public static void checkPageHasAscending1Difference(List<Integer> pageList) {
        if (pageList.get(0) + 1 != pageList.get(1)) {
            throw new IllegalStateException();
        }
    }

    public static void checkListInGivenRange(List<Integer> pageList) {
        if (pageList.get(0) <= START_PAGE) {
            throw new IllegalStateException();
        }
        if (pageList.get(1) >= END_PAGE) {
            throw new IllegalStateException();
        }
    }

    public static void checkLeftPageIsOdd(List<Integer> pageList) {
        if (pageList.get(0) % 2 == 0) {
            throw new IllegalStateException();
        }
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
