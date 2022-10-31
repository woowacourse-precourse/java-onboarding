package onboarding;

import java.util.stream.IntStream;

public class Problem3 {
    public static int count369(int n) {
        return (int) String.valueOf(n).chars()
                .filter(o -> o == '3' || o == '6' || o == '9')
                .count();
    }

    public static int solution(int number) {
        return IntStream.range(1, number + 1)
                .map(Problem3::count369)
                .sum();
    }
}
