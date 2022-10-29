package onboarding;

import java.util.Objects;

public class Problem3 {
    private static final int START_NUMBER = 1;

    public static int solution(int number) {
        int answer = 0;
        answer = findResult(number);
        return answer;
    }

    private static int findResult(int number) {
        int result = 0;
        for (int i = START_NUMBER; i <= number; i++) {
            result += Number.countClapOfNumber(i);
        }
        return result;
    }

    static class Number {
        public static int countClapOfNumber(int number) {
            int clap = 0;
            for (int i = number; i > 0; i = i / 10) {
                if (hasThreeOrSixOrNine(i % 10)) {
                    clap++;
                }
            }
            return clap;
        }

        private static boolean hasThreeOrSixOrNine(int digit) {
            return Objects.equals(3, digit) || Objects.equals(6, digit) || Objects.equals(9, digit);
        }
    }
}
