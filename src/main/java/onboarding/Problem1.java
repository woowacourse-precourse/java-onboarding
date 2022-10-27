package onboarding;

import java.util.List;

class Problem1 {
    static final int POVIWIN = 1;
    static final int CRONGWIN = 2;
    static final int DRAW = 0;
    static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiScore;
        int crongScore;

        if (noException(pobi) && noException(crong)) {
            pobiScore = pageScoreCompare(pobi);
            crongScore = pageScoreCompare(crong);
            return compareScore(pobiScore, crongScore);
        }

        return EXCEPTION;
    }

    private static int compareScore(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return POVIWIN;
        }

        if (crongScore > pobiScore) {
            return CRONGWIN;
        }

        return DRAW;
    }

    private static boolean noException(List<Integer> person) {
        int leftPageNum = person.get(0);
        int rightPageNum = person.get(1);

        if (leftPageNum + 1 != rightPageNum) return false;
        if (rightPageNum == 1 || leftPageNum == 400) return false;
        if (leftPageNum % 2 == 0) return false;
        if (rightPageNum % 2 == 1) return false;
        return true;
    }

    private static int pageScoreCompare(List<Integer> person) {
        int leftPageScore = pageScore(person.get(0));
        int rightPageScore = pageScore(person.get(1));
        if (leftPageScore > rightPageScore) {
            return leftPageScore;
        }

        return rightPageScore;
    }

    private static int pageScore(int page) {
        int oneNumber;
        int tenNumber;
        int hundredNumber;
        int sumNum;
        int multiplyNum;

        if (page / 100 != 0) {
            oneNumber = page % 10;
            tenNumber = (page % 100) / 10;
            hundredNumber = page / 100;
            sumNum = sumNumber(oneNumber, tenNumber, hundredNumber);
            multiplyNum = multiplyNumber(oneNumber, tenNumber, hundredNumber);
            return compareNumber(sumNum, multiplyNum);
        }

        if (page / 10 != 0) {
            oneNumber = page % 10;
            tenNumber = page / 10;
            sumNum = sumNumber(oneNumber, tenNumber, 0);
            multiplyNum = multiplyNumber(oneNumber, tenNumber, 1);
            return compareNumber(sumNum, multiplyNum);
        }

        return page;
    }

    private static int compareNumber(int sumNum, int multiplyNum) {
        if (sumNum > multiplyNum) return sumNum;
        return multiplyNum;
    }

    private static int multiplyNumber(int oneNumber, int tenNumber, int hundredNumber) {
        return oneNumber * tenNumber * hundredNumber;
    }

    private static int sumNumber(int oneNumber, int tenNumber, int hundredNumber) {
        return oneNumber + tenNumber + hundredNumber;
    }
}