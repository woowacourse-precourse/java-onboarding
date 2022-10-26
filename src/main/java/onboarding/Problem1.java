package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiMaxResult = getMaxLeftAndRight(pobi);
        int crongMaxResult = getMaxLeftAndRight(crong);

        if (pobiMaxResult > crongMaxResult) {
            return 1;
        }
        if (pobiMaxResult < crongMaxResult) {
            return 2;
        }

        return 0;
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
        return pages.get(0);
    }

    private static int getRightPageNum(List<Integer> pages) {
        return pages.get(1);
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