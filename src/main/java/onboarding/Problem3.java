package onboarding;

import java.util.Arrays;

public class Problem3 {
    private static int[] numbers = {3, 6, 9};

    public static boolean hasThreeSixNine(int target) {
        return Arrays.stream(numbers).anyMatch(number -> number == target);
    }

    public static int countTargetNumber(int targetNumber) {
        int cumulativeCount = 0;
        int exponent = (Integer.toString(targetNumber).length() - 1);

        while (exponent >= 0) {
            int digit = (int) Math.pow(10, exponent);
            int target = targetNumber / digit;
            if (hasThreeSixNine(target)) {
                cumulativeCount++;
            }

            targetNumber %= digit;
            exponent--;
        }

        return cumulativeCount;
    }

    public static int solution(int number) {
        int answer = 0;
        for (int targetNumber = 1; targetNumber <= number; targetNumber++) {
            answer += countTargetNumber(targetNumber);
        }

        return answer;
    }
}
