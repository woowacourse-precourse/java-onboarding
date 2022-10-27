package onboarding;

import java.util.List;
import java.util.stream.IntStream;

public class Problem3 {
    private static final List<Integer> conditionNums = List.of(3, 6, 9);

    public static int solution(int number) {
        int[] numRange = getNumRange(number);
        return 0; // 임시
    }

    private static int[] getNumRange(int number) {
        return IntStream.rangeClosed(1, number).toArray();
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
