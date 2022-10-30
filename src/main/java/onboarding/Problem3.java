package onboarding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Problem3 {
    private static final Set<String> clapNumbers = new HashSet<>(List.of("3", "6", "9"));
    private static final String SPACE = "";

    public static int solution(int number) {
        return IntStream.range(1, number + 1)
                .map(Problem3::claps)
                .sum();
    }

    private static int claps(int number) {
        return (int) Arrays.stream(String.valueOf(number).split(SPACE))
                .filter(clapNumbers::contains)
                .count();
    }
}
