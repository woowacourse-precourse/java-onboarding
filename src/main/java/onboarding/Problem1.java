package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    private static final int MINIMUM_INPUT = 1;
    private static final int MAXIMUM_INPUT = 400;
    private static final int INPUT_ERROR = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isExceptionCase(pobi, crong)) return INPUT_ERROR;

        int pobiMax = getLeftRightMax(pobi.get(0).toString(),pobi.get(1).toString());
        int crongMax = getLeftRightMax(crong.get(0).toString(),crong.get(1).toString());

        int answer = Integer.compare(pobiMax, crongMax);
        return (answer > -1) ? answer : 2;
    }

    private static int getLeftRightMax(String left, String right) {
        return Math.max(getMaxNum(left), getMaxNum(right));
    }

    private static int getMaxNum(String numStr) {
        int sum = Stream.of(numStr.split(""))
                .mapToInt(Integer::parseInt)
                .sum();
        int multiply = Stream.of(numStr.split(""))
                .mapToInt(Integer::parseInt)
                .reduce(1, (x, y) -> x * y);
        return Math.max(sum, multiply);
    }

    private static boolean isExceptionCase(List<Integer> pobi, List<Integer> crong) {
        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);

        if (pobiLeft >= pobiRight || pobiLeft < MINIMUM_INPUT || pobiRight > MAXIMUM_INPUT) return true;
        if (crongLeft >= crongRight || crongLeft < MINIMUM_INPUT || crongRight > MAXIMUM_INPUT) return true;
        if (pobiRight - pobiLeft != 1) return true;
        if (crongRight - crongLeft != 1) return true;

        return false;
    }

}
