package onboarding;

import java.util.List;
import java.util.stream.IntStream;

public class Problem3 {
    private static final int MIN_RANGE = 1;
    private static final List<Integer> conditionNums = List.of(3, 6, 9);

    public static int solution(int number) {
        int[] numRange = getNumRange(number);
        return getSum(numRange);
    }

    private static int[] getNumRange(int number) {
        return IntStream.rangeClosed(MIN_RANGE, number).toArray();
    }

    private static int getSum(int[] numRange) {
        int result = 0;
        for (int num : numRange) {
            result = result + getCnt(num);
        }
        return result;
    }

    private static int getCnt(int number) {
        int cnt = 0;
        while (number != 0) {
            if (conditionNums.contains(number % 10)) {
                cnt++;
            }
            number /= 10;
        }
        return cnt;
    }
}
