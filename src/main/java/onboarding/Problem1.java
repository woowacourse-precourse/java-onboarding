package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    static final int PAGE_MIN = 1;
    static final int PAGE_MAX = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isValidPageNumbers(pobi) || !isValidPageNumbers(crong)) {
            return -1;
        }

        Integer pobiScore = scoreOfPages(pobi);
        Integer crongScore = scoreOfPages(crong);

        Integer result = -1;
        if (pobiScore.equals(crongScore)) {
            result = 0;
        }
        else if (pobiScore > crongScore) {
            result = 1;
        }
        else if (pobiScore < crongScore) {
            result = 2;
        }
        return result;
    }

    private static Boolean isValidPageNumbers(List<Integer> pages) {
        Integer leftPageNum = pages.get(0);
        Integer rightPageNum = pages.get(1);

        Boolean leftIsInRange = (PAGE_MIN <= leftPageNum && leftPageNum <= PAGE_MAX);
        Boolean rightIsInRange = (PAGE_MIN <= rightPageNum && rightPageNum <= PAGE_MAX);
        Boolean leftIsOdd = (leftPageNum % 2 == 1);
        Boolean rightIsEven = (rightPageNum % 2 == 0);
        Boolean isAdjacent = (leftPageNum + 1 == rightPageNum);

        return (leftIsInRange && rightIsInRange && leftIsOdd && rightIsEven && isAdjacent);
    }

    private static Integer scoreOfPages(List<Integer> pages) {
        Integer leftPageNum = pages.get(0);
        Integer rightPageNum = pages.get(1);

        Integer leftScore = scoreOfPageNum(leftPageNum);
        Integer rightScore = scoreOfPageNum(rightPageNum);

        return Integer.max(leftScore, rightScore);
    }

    private static Integer scoreOfPageNum(Integer pageNum) {
        List<Integer> digits = parseIntegerToDigits(pageNum);
        Integer score = maxOfSumAndProduct(digits);

        return score;
    }

    private static List<Integer> parseIntegerToDigits(Integer value) {
        ArrayList<Integer> digits = new ArrayList<>();

        while (value > 0) {
            Integer lastDigit = value % 10;
            digits.add(0, lastDigit);
            value /= 10;
        }

        return digits;
    }

    private static Integer maxOfSumAndProduct(List<Integer> list) {
        Integer sum = list.stream().reduce(0, (a, b) -> a + b);
        Integer product = list.stream().reduce(1, (a, b) -> a * b);

        return Integer.max(sum, product);
    }
}