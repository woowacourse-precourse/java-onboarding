package onboarding;

import problem1.Calculator;
import problem1.pageException;

import java.util.List;

import static java.lang.Math.max;

class Problem1 {
    private static final int SUM = 0;
    private static final int MUL = 1;
    private static Calculator calculator = new Calculator();
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static int getMaxValue(List<Integer> pages) throws pageException {
        checkException(pages.get(0), pages.get(1));

        int maxVal = 0;
        for (Integer integer : pages) {
            maxVal = max(maxVal, max(calculator.digitCalculate(integer, SUM), calculator.digitCalculate(integer, MUL)));
        }
        return maxVal;
    }
}