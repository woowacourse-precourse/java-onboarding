package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    private static final int OVER_MIN_PAGE = 1;
    private static final int OVER_MAX_PAGE = 400;
    private static final int NEXT_PAGE = 1;
    private static final int ODD_NUMBER = 0;
    private static final int EVEN_NUMBER = 1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;
        int pobiGameResult = getMaxNumberBetweenLeftAndRightPage(pobi);
        int crongGameResult = getMaxNumberBetweenLeftAndRightPage(crong);

        if (exceptionCondition(pobi) || exceptionCondition(crong)) {
            return -1;
        } else if (pobiGameResult > crongGameResult) {
            return 1;
        } else if (pobiGameResult < crongGameResult) {
            return 2;
        } else if (pobiGameResult == crongGameResult) {
            return 0;
        }
        return answer;
    }
    private static boolean exceptionCondition(List<Integer> person) {
        int leftPageNumber = person.get(ODD_NUMBER);
        int rightPageNumber = person.get(EVEN_NUMBER);
        return isNotNextPage(leftPageNumber, rightPageNumber) || isNotEvenOrOddNumber(leftPageNumber, rightPageNumber) || isOverMaxOrMinPage(leftPageNumber, rightPageNumber);
    }

    private static boolean isNotNextPage(int leftPageNumber, int rightPageNumber) {
        return rightPageNumber - leftPageNumber != NEXT_PAGE;
    }

    private static boolean isNotEvenOrOddNumber(int leftPageNumber, int rightPageNumber) {
        return leftPageNumber % 2 != 1 || rightPageNumber % 2 != 0;
    }

    private static boolean isOverMaxOrMinPage(int leftPageNumber, int rightPageNumber) {
        return (leftPageNumber >= OVER_MAX_PAGE || rightPageNumber >= OVER_MAX_PAGE || leftPageNumber <= OVER_MIN_PAGE || rightPageNumber <= OVER_MIN_PAGE);
    }

    private static List<Integer> findDigits(int inputNumber) {
        List<Integer> digitList = new ArrayList<>();
        while (inputNumber > 0) {
            digitList.add(inputNumber % 10);
            inputNumber /= 10;
        }
        return digitList;
    }

    private static int getMaxNumberBetweenSumAndMultiple(List<Integer> digitsOfNumbers) {
        int sum = digitsOfNumbers.stream().reduce(0, (a, b) -> a + b);
        int multiple = digitsOfNumbers.stream().reduce(1, (a, b) -> a * b);
        return Math.max(sum, multiple);
    }

    private static int getMaxNumberBetweenLeftAndRightPage(List<Integer> person) {
        int leftNumber = person.get(ODD_NUMBER);
        int rightNumber = person.get(EVEN_NUMBER);

        int leftResult = getMaxNumberBetweenSumAndMultiple(findDigits(leftNumber));
        int rightResult = getMaxNumberBetweenSumAndMultiple(findDigits(rightNumber));

        return Math.max(leftResult, rightResult);
    }
}