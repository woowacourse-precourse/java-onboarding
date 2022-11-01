package onboarding;

import java.util.stream.Stream;

public class Problem3 {
    public static int solution(int number) {
        int answer = Stream.iterate(1, i -> i <= number, i -> i + 1)
                .mapToInt(value -> {
                    int ret = 0;
                    while (value != 0) {
                        int digit = value % 10;
                        if (digit == 3 || digit == 6 || digit == 9) {
                            ++ret;
                        }
                        value /= 10;
                    }
                    return ret;
                }).sum();

        return answer;
    }
}
