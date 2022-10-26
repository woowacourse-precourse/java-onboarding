package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int DRAW = 0;
    private static final int EXCEPTION = -1;
    private static final int LEFT_PAGE = 0;
    private static final int RIGHT_PAGE = 1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isError(pobi) || isError(crong)) {
            return EXCEPTION;
        }

        int pobiMaxResult = getMaxLeftAndRight(pobi);
        int crongMaxResult = getMaxLeftAndRight(crong);

        if (pobiMaxResult > crongMaxResult) {
            return POBI_WIN;
        }
        if (pobiMaxResult < crongMaxResult) {
            return CRONG_WIN;
        }

        return DRAW;
    }

    private static boolean isError(List<Integer> pobi) {
        return getRightPageNum(pobi) - getLeftPageNum(pobi) != 1;
    }

    private static int getMaxLeftAndRight(List<Integer> pages) {
        int leftPageNum = getLeftPageNum(pages);
        int rightPageNum = getRightPageNum(pages);

        List<Integer> leftPageDigit = splitToDigitList(leftPageNum);
        List<Integer> rightPageDigit = splitToDigitList(rightPageNum);

        int leftPageMax = getMaxSumAndMultiply(leftPageDigit);
        int rightPageMax = getMaxSumAndMultiply(rightPageDigit);

        return Math.max(leftPageMax, rightPageMax);

    }


    private static int getLeftPageNum(List<Integer> pages) {
        return pages.get(LEFT_PAGE);
    }

    private static int getRightPageNum(List<Integer> pages) {
        return pages.get(RIGHT_PAGE);
    }

    private static int getMaxSumAndMultiply(List<Integer> digitList) {

        return Integer.max(getDigitSum(digitList), getDigitMultiply(digitList));
    }

    private static List<Integer> splitToDigitList(int number) {

        List<Integer> digitList = new ArrayList<>();
        while (number != 0) {
            digitList.add(number % 10);
            number /= 10;
        }

        return digitList;
    }

    private static int getDigitSum(List<Integer> digitList) {

        return digitList.stream().reduce(0, Integer::sum);

    }

    private static int getDigitMultiply(List<Integer> digitList) {

        return digitList.stream().reduce(1, (x, y) -> x * y);

    }

}