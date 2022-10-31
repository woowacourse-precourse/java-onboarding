package onboarding;

import java.util.List;

class Problem1 {
    private static final int START_PAGE = 1;
    private static final int END_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiScore;
        int crongScore;

        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);

        if (!validateInput(pobiLeft, pobiRight) || !validateInput(crongLeft, crongRight)) {
            return -1;
        }

    }

    private static boolean validateInput(int leftPage, int rightPage) {
        if (leftPage <= START_PAGE || rightPage >= END_PAGE) {
            return false;
        }
        if (!isContinuous(leftPage, rightPage)) {
            return false;
        }
        if (!isOdd(leftPage) || isOdd(rightPage)) {
            return false;
        }
        return true;
    }

    private static boolean isContinuous(int leftPageNum, int rightPageNum) {
        if ((rightPageNum - leftPageNum) != 1) {
            return false;
        }
        return true;
    }

    private static boolean isOdd(int num) {
        if ((num % 2) == 0) {
            return false;
        }
        return true;
    }
}