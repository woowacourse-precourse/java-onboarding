package onboarding;

import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        return calculateTotalClaps(number);
    }

    private static int calculateTotalClaps(int number) {
        int totalClaps = 0;
        for (int currentNumber = 1; currentNumber <= number; currentNumber++) {
            int claps = 0;
            List<String> digits = List.of(String.valueOf(currentNumber).split(""));
            for (String digit : digits) {
                if (digit.equals("3") || digit.equals("6") || digit.equals("9")) {
                    claps++;
                }
            }
            totalClaps += claps;
        }
        return totalClaps;
    }
}
