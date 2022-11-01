package onboarding;

import java.util.List;

class Problem1 {
    private static final int POBBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int DRAW = 0;
    private static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!(isValid(pobi) && isValid(crong))) return EXCEPTION;

        int pobiMax = leftOrRight(pobi);
        int crongMax = leftOrRight(crong);

        if (pobiMax == crongMax) return DRAW;
        return (pobiMax > crongMax) ? POBBI_WIN : CRONG_WIN;
    }

    private static int digitSum(int pageNum) {
        int sum = 0;
        while (pageNum > 0) {
            sum += (pageNum % 10);
            pageNum /= 10;
        }
        return sum;
    }

    private static int digitProduct(int pageNum) {
        int sum = 1;
        while (pageNum > 0) {
            sum *= (pageNum % 10);
            pageNum /= 10;
        }
        return sum;
    }

    private static int sumOrProduct(int pageNum) {
        int sum = digitSum(pageNum);
        int product = digitProduct(pageNum);
        return Math.max(sum, product);
    }

    private static int leftOrRight(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);
        int leftMax = sumOrProduct(leftPage);
        int rightMax = sumOrProduct(rightPage);

        return Math.max(leftMax, rightMax);
    }

    private static  boolean isValid(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        if (leftPage > 400 || leftPage <= 0) return false;
        if (leftPage % 2 == 0) return false;
        if (rightPage != leftPage + 1) return false;

        return true;
    }
}