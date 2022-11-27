package onboarding;

import java.util.List;

public class Problem3 {

    public static final String COUNT_THREE = "3";
    public static final String COUNT_SIX = "6";
    public static final String COUNT_NINE = "9";

    public static int solution(int number) {
        return calculateTotalClaps(number);
    }

    private static int calculateTotalClaps(int number) {
        int totalClaps = 0;
        for (int currentNumber = 1; currentNumber <= number; currentNumber++) {
            totalClaps += calculateCurrentNumberClaps(currentNumber);
        }
        return totalClaps;
    }

    private static int calculateCurrentNumberClaps(int currentNumber) {
        int claps = 0;
        for (String digit : splitNumberToDigits(currentNumber)) {
            if (hasToClap(digit)) {
                claps++;
            }
        }
        return claps;
    }

    private static boolean hasToClap(String digit) {
        return digit.equals(COUNT_THREE) || digit.equals(COUNT_SIX) || digit.equals(COUNT_NINE);
    }

    private static List<String> splitNumberToDigits(int currentNumber) {
        return List.of(String.valueOf(currentNumber).split(""));
    }
}
