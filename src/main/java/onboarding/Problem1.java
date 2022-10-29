package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {

    private static final int EXCEPTION = -1;
    private static final int DRAW = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int INPUT_LEN = 2;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isValidInput(pobi) || !isValidInput(crong)) {
            return EXCEPTION;
        }

        int pobiScore = computeScore(pobi.get(0), pobi.get(1));
        int crongScore = computeScore(crong.get(0), crong.get(1));

        return computeMatch(pobiScore, crongScore);
    }

    private static int computeMatch(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return POBI_WIN;
        }
        if (pobiScore < crongScore) {
            return CRONG_WIN;
        }
        return DRAW;
    }

    private static int computeScore(int leftPageNum, int rightPageNum) {
        int leftPageScore = Math.max(plusEachDigit(leftPageNum), multiplyEachDigit(leftPageNum));
        int rightPageScore = Math.max(plusEachDigit(rightPageNum), multiplyEachDigit(rightPageNum));

        return Math.max(leftPageScore, rightPageScore);
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
        if (input.size() != INPUT_LEN) {
            return false;
        }

        int leftPageNum = input.get(0);
        int rightPageNum = input.get(1);

        return isOdd(leftPageNum) && !isOdd(rightPageNum) && leftPageNum + 1 == rightPageNum;
    }

    private static boolean isOdd(int num) {
        return num % 2 == 1;
    }
}