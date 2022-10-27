package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {

    private static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isValidInput(pobi) || isValidInput(crong)) {
            return EXCEPTION;
        }

        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static int computeScore(List<Integer> input) {
        return 0;
    }

    private static int plusEachDigit(int num) {
        return Arrays.stream(String.valueOf(num)
                .split(""))
            .map(Integer::parseInt)
            .reduce((n1, n2) -> n1 + n2)
            .get();
    }

    private static int multiplyEachDigit(int num) {
        return Arrays.stream(String.valueOf(num)
                .split(""))
            .map(Integer::parseInt)
            .reduce((n1, n2) -> n1 * n2)
            .get();
    }

    private static boolean isValidInput(List<Integer> input) {
        int leftPageNum = input.get(0);
        int rightPageNum = input.get(1);

        if (!isOdd(leftPageNum) || isOdd(rightPageNum) || leftPageNum + 1 != rightPageNum) {
            return false;
        }
        return true;
    }

    private static boolean isOdd(int num) {
        if (num % 2 == 1) {
            return true;
        }
        return false;
    }
}