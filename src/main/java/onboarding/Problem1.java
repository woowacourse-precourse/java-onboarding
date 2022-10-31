package onboarding;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Problem1 {

    private static final int CRONG_MORE_BIGGER = 2;
    private static final int POBI_MORE_BIGGER = 1;
    private static final int SAME_VALUE = 0;
    private static final int EXCEPTION_CASE = -1;

    private static final int LEFT_PAGE_INDEX = 0;
    private static final int RIGHT_PAGE_INDEX = 1;

    private static final int FIRST_PAGE = 1;
    private static final int LAST_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        return getAnswer(getMaxValue(pobi), getMaxValue(crong));
    }

    private static Integer getMaxValue(List<Integer> pages) {
        Integer leftPage = pages.get(LEFT_PAGE_INDEX);
        Integer rightPage = pages.get(RIGHT_PAGE_INDEX);

        if (isExceptionCase(leftPage, rightPage)) {
            return EXCEPTION_CASE;
        }

       int leftPageMaxValue = calculateEachPagesMaxValue(leftPage);
       int rightPageMaxValue = calculateEachPagesMaxValue(rightPage);

       return Math.max(leftPageMaxValue, rightPageMaxValue);
    }

    private static boolean isExceptionCase(Integer leftPage, Integer rightPage) {
        if ((leftPage + 1) != rightPage) {
            return true;
        }

        if (leftPage == FIRST_PAGE && rightPage == FIRST_PAGE + 1) {
            return true;
        }
        return leftPage == LAST_PAGE - 1 && rightPage == LAST_PAGE;
    }

    private static int calculateEachPagesMaxValue(Integer page) {
        List<Integer> eachNumbers = getEachNumbers(page);

        int sum = eachNumbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        int multiply = eachNumbers.stream()
                .mapToInt(Integer::intValue)
                .reduce(1, (i, j) -> i * j);

        return Math.max(sum, multiply);
    }

    private static List<Integer> getEachNumbers(Integer page) {
        return Stream.of(page.toString().split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int getAnswer(Integer x, Integer y) {
        if (x == EXCEPTION_CASE || y == EXCEPTION_CASE) {
            return EXCEPTION_CASE;
        }
        return (x < y) ? CRONG_MORE_BIGGER : ((x.equals(y) ? SAME_VALUE : POBI_MORE_BIGGER));
    }
}