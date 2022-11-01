package onboarding;

import java.util.stream.IntStream;

public class Problem3 {
    public static int solution(int number) {
        return (int) IntStream.range(1, number+1)
            .mapToLong(Problem3::clap)
            .sum();
    }

    private static int clap(int number) {
        int count = 0;
        String s = String.valueOf(number);

        count += s.chars()
            .filter(c -> c == '3')
            .count();

        count += s.chars()
            .filter(c -> c == '6')
            .count();

        count += s.chars()
            .filter(c -> c == '9')
            .count();

        return count;
    }
}
