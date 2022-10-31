package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int clapCount = 0;
        for (int i = 1; i <= number; i++) {

            for (int digit : convertDigits(i)) {
                if (isThreeSixNine(digit)) {
                    clapCount++;
                }
            }
        }
        return clapCount;
    }

    private static boolean isThreeSixNine(int digit) {
        return digit == 3 || digit == 6 || digit == 9;
    }

    public static int[] convertDigits(int number) {
        String str = String.valueOf(number);
        int[] digits = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            digits[i] = str.charAt(i) - '0';
        }
        return digits;
    }

    public static List<Integer> convertDigitsList(int number) {
        List<Integer> digitList = new ArrayList<>();
        while (number != 0) {
            digitList.add(0, number % 10);
            number /= 10;
        }
        return digitList;
    }
}

class Problem3First {
    public static int solution(int number) {
        int clapCount = 0;
        for (int i = 1; i <= number; i++) {
            int nowNumber = i;
            while (nowNumber != 0) {
                int remainder = nowNumber % 10;
                if (remainder == 3 || remainder == 6 || remainder == 9) {
                    clapCount++;
                }
                nowNumber /= 10;
            }
        }
        return clapCount;
    }
}
