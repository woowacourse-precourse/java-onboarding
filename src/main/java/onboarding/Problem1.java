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

        pobiScore = Math.max(computeNum(pobiLeft), computeNum(pobiRight));
        crongScore = Math.max(computeNum(crongLeft), computeNum(crongRight));

        if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore < crongScore){
            return 2;
        }
        return 0;
    }

    private static int computeNum(int num) {
        int sumResult = 0;
        int mulResult = 1;

        while(num != 0) {
            sumResult += (num % 10);
            mulResult *= (num % 10);
            num /= 10;
        }
        return Math.max(sumResult, mulResult);
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