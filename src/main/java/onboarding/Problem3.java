package onboarding;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * a. 1 ~ number 범위의 int[] 배열 생성 기능 구현
 * b. 1 ~ number 범위의 각 각의 숫자에서 박수 횟수 계산하는 기능 구현
 * */
public class Problem3 {
    public static int solution(int number) {
        int count = 0;
        int[] numbers = IntStream.rangeClosed(1, number).toArray();

        for (int n : numbers) {
            count += calApplauseCount(n);
        }

        return count;
    }

    private static int calApplauseCount(int n) {
        return Arrays.stream(String.valueOf(n).split(""))
                .mapToInt(Integer::valueOf)
                .filter(i -> i != 0 && i % 3 == 0)
                .toArray().length;
    }
}
