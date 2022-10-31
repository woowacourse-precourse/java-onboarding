package onboarding;

import java.util.stream.IntStream;

public class Problem3 {
    public static int solution(int number) {
        return IntStream.rangeClosed(1, number)
                .map(Problem3::count369Digits)
                .sum();
    }

    private static int count369Digits(int n) {
        int count = 0;
        while (0 < n) {
            int curDigit = n % 10;
            count += is369Digit(curDigit) ? 1 : 0;
            n /= 10;
        }
        return count;
    }

    private static boolean is369Digit(int n) {
        return (n == 3) || (n == 6) || (n == 9);
    }
}
