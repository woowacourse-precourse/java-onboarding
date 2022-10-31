package onboarding;

import java.io.File;
import java.util.List;

class Problem1 {
    private static final int EXCEPTION_NUMBER = -1;
    private static final int DRAW_NUMBER = 0;
    private static final int WIN_POBI_NUMBER = 1;
    private static final int WIN_CRONG_NUMBER = 2;
    private static final int FIRST_PAGE_OF_BOOK = 1;
    private static final int LAST_PAGE_OF_BOOK = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;

        if (isNotTwoElements(pobi) || isNotBookPage(pobi) || isNotSidePage(pobi)) {
            return EXCEPTION_NUMBER;
        }

        if (isNotTwoElements(crong) || isNotBookPage(crong) || isNotSidePage(crong)) {
            return EXCEPTION_NUMBER;
        }

        int pobiLargerNumber = getLargerNumber(pobi);
        int crongLargerNumber = getLargerNumber(crong);

        answer = getAnswerByCompareNumber(pobiLargerNumber, crongLargerNumber);

        return answer;
    }

    private static boolean isNotBookPage(List<Integer> checkList) {
        return FIRST_PAGE_OF_BOOK > checkList.get(0) || checkList.get(0) > LAST_PAGE_OF_BOOK
                || FIRST_PAGE_OF_BOOK > checkList.get(1) || checkList.get(1) > LAST_PAGE_OF_BOOK;
    }

    private static boolean isNotTwoElements(List<Integer> checkList) {
        return checkList.size() != 2;
    }

    private static boolean isNotSidePage(List<Integer> checkList) {
        return checkList.get(0) != checkList.get(1) - 1;
    }

    private static int getSum(int number) {
        int result = 0;

        while (number != 0) {
            result += number % 10;
            number /= 10;
        }

        return result;
    }

    private static int getMultiplication(int number) {
        int result = 1;

        while (number != 0) {
            result *= number % 10;
            number /= 10;
        }

        return result;
    }

    private static int getLargerNumber(List<Integer> checkList) {
        int leftSumResult = getSum(checkList.get(0));
        int leftMultiplicationResult = getMultiplication(checkList.get(0));
        int rightSumResult = getSum(checkList.get(1));
        int rightMultiplicationResult = getMultiplication(checkList.get(1));

        int leftLargerNumber = Math.max(leftSumResult, leftMultiplicationResult);
        int rightLargerNumber = Math.max(rightSumResult, rightMultiplicationResult);

        return Math.max(leftLargerNumber, rightLargerNumber);
    }

    private static int getAnswerByCompareNumber(int pobiNumber, int crongNumber) {
        if (pobiNumber == crongNumber) {
            return DRAW_NUMBER;
        } else if (pobiNumber > crongNumber) {
            return WIN_POBI_NUMBER;
        }

        return WIN_CRONG_NUMBER;
    }
}
