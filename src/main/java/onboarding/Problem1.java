package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiScore = getMaxNumber(pobi);
        int crongScore = getMaxNumber(crong);

        return compareScore(pobiScore, crongScore);
    }

    private static int getMaxNumber(List<Integer> page) {
        int leftPage = page.get(0);
        int rightPage = page.get(1);

        if (!validationCheck(leftPage, rightPage)) return -1;

        int leftPageMaxNumber = Math.max(getMaxNumberWithAdd(leftPage), getMaxNumberWithMultiply(leftPage));
        int rightPageMaxNumber = Math.max(getMaxNumberWithAdd(rightPage), getMaxNumberWithMultiply(rightPage));

        return Math.max(leftPageMaxNumber, rightPageMaxNumber);
    }

    private static int getMaxNumberWithAdd(int pageNumber) {
        String tmp = Integer.toString(pageNumber);
        int ret = 0;

        for (int i = 0; i < tmp.length(); i++) {
            ret += tmp.charAt(i) - '0';
        }

        return ret;
    }

    private static int getMaxNumberWithMultiply(int pageNumber) {
        String tmp = Integer.toString(pageNumber);
        int ret = 1;

        for (int i = 0; i < tmp.length(); i++) {
            ret *= tmp.charAt(i) - '0';
        }

        return ret;
    }

    private static int compareScore(int pobiScore, int crongScore) {
        if (pobiScore == -1 || crongScore == -1) return -1;
        if (pobiScore > crongScore) return 1;
        if (pobiScore < crongScore) return 2;
        return 0;
    }

    private static boolean validationCheck(int leftPage, int rightPage) {
        if (isOutOfBoundary(leftPage) || isOutOfBoundary(rightPage)) return false;
        if (isLeftPageOdd(leftPage) && isRightPageEven(rightPage)) return true;
        return false;
    }

    private static boolean isLeftPageOdd(int leftPage) {
        if (leftPage % 2 == 0) return false;
        return true;
    }

    private static boolean isRightPageEven(int rightPage) {
        if (rightPage % 2 == 0) return true;
        return false;
    }

    private static boolean isOutOfBoundary(int page) {
        if (page < 1 || page > 400) return true;
        return false;
    }
}