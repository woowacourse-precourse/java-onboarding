package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    private static final int CRONG_MORE_BIGGER = 2;
    private static final int POBI_MORE_BIGGER = 1;
    private static final int SAME_VALUE = 0;
    private static final int EXCEPTION_CASE = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = getAnswer(getMaxValue(pobi), getMaxValue(crong));
        return answer;
    }

    private static Integer getMaxValue(List<Integer> pages) {
        Integer leftPage = pages.get(0);
        Integer rightPage = pages.get(1);
        if ((leftPage + 1) != rightPage) {
            return EXCEPTION_CASE;
        }

        int leftPageMaxValue = doCalculate(leftPage);
        int rightPageMaxValue = doCalculate(rightPage);

        return Math.max(leftPageMaxValue, rightPageMaxValue);
    }

    private static int doCalculate(Integer page) {
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
        List<Integer> eachNumbers = new ArrayList<>();
        int loopTimes = page.toString().length();
        for (int i = 0; i < loopTimes; i++) {
            eachNumbers.add(page % 10);
            page /= 10;
        }

        return eachNumbers;
    }


    private static int getAnswer(Integer x, Integer y) {
        if (x == EXCEPTION_CASE || y == EXCEPTION_CASE) {
            return EXCEPTION_CASE;
        }
        return (x < y) ? CRONG_MORE_BIGGER : ((x.equals(y) ? SAME_VALUE : POBI_MORE_BIGGER));
    }
}