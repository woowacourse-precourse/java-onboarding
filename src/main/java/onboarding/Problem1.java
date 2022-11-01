package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    /**
     * 유효한 페이지 번호의 최솟값
     */
    static final int PAGE_MIN = 1;
    
    /**
     * 유효한 페이지 번호의 최댓값
     */
    static final int PAGE_MAX = 400;

    /**
     * pobi, crong의 양쪽 페이지 번호를 입력받아 승자를 가립니다.
     * pobi가 이겼을 경우 1, crong이 이겼을 경우 2, 비겼을 경우 0, 입력이 유효하지 않을 경우 -1을 리턴합니다.
     */
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

    /**
     * 양쪽 페이지 번호가 유효하면 {@code true}, 그렇지 않다면 {@code false}를 리턴합니다.
     */
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

    /**
     * 양쪽 페이지 번호의 점수를 리턴합니다.
     */
    private static Integer scoreOfPages(List<Integer> pages) {
        Integer leftPageNum = pages.get(0);
        Integer rightPageNum = pages.get(1);

        Integer leftScore = scoreOfPageNum(leftPageNum);
        Integer rightScore = scoreOfPageNum(rightPageNum);

        return Integer.max(leftScore, rightScore);
    }

    /**
     * 페이지 번호의 점수를 리턴합니다.
     */
    private static Integer scoreOfPageNum(Integer pageNum) {
        List<Integer> digits = parseIntegerToDigits(pageNum);
        Integer score = maxOfSumAndProduct(digits);

        return score;
    }

    /**
     * 주어진 정수의 각 자릿수를 원소로 가지는 리스트를 리턴합니다.
     */
    private static List<Integer> parseIntegerToDigits(Integer value) {
        ArrayList<Integer> digits = new ArrayList<>();

        while (value > 0) {
            Integer lastDigit = value % 10;
            digits.add(0, lastDigit);
            value /= 10;
        }

        return digits;
    }

    /**
     * 리스트의 원소들의 합과 곱 중에 더 큰 것을 리턴합니다.
     */
    private static Integer maxOfSumAndProduct(List<Integer> list) {
        Integer sum = list.stream().reduce(0, (a, b) -> a + b);
        Integer product = list.stream().reduce(1, (a, b) -> a * b);

        return Integer.max(sum, product);
    }
}