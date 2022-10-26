package onboarding;

import java.util.List;

public class Problem3 {
    private final static List<Integer> clapTargets = List.of(3, 6, 9);
    public static int solution(int number) {
        int totalClaps = 0;
        int currentNumber = 1;
        while (currentNumber <= number) {
            totalClaps += clapsOf(currentNumber);
            currentNumber += 1;
        }
        return totalClaps;
    }

    private static int clapsOf(int number) {
        int claps = 0;
        while (number != 0) {
            int lastDigit = number % 10;
            if (Problem3.clapTargets.contains(lastDigit)) {
                claps += 1;
            }
            number /= 10;
        }
        return claps;
    }
}
