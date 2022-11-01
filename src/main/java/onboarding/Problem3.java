package onboarding;

import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = extractingNumbers(number);
        return answer;
    }

    private static int extractingNumbers(int number) {
        int result = 0;
        for (int i = 1; i <= number; i++) {
            if (checkingNumber(i)) {
                result += includedCountingCheck(i);
            }
        }
        return result;
    }

    private static boolean checkingNumber(int number) {
        while (true) {
            if (number % 10 == 3 || number % 10 == 6 || number % 10 == 9) {
                return true;
            }
            if (number / 10 == 0) {
                return false;
            }
            number /= 10;
        }
    }

    private static int includedCountingCheck(int number) {
        int count = 0;
        while (true) {
            if (number % 10 == 3 || number % 10 == 6 || number % 10 == 9) {
                count++;
            }
            if (number / 10 == 0) {
                return count;
            }

            number /= 10;
        }
    }

}
