package onboarding;

import onboarding.problem3.ClapNumber;

import java.util.Arrays;

public class Problem3 {
    public static int solution(int number) {
        return get369CountFromOneToNumber(number);
    }

    private static String intToString(int number) {
        return String.valueOf(number);
    }

    public static int get369CountFromOneToNumber(int number) {
        int result = 0;
        for (int i = 1; i <= number; i++) {
            result += get369Count(i);
        }
        return result;
    }

    private static long get369Count(int number) {
        return intToString(number).chars()
                .filter(digit -> is369DigitChar(intToChar(digit)))
                .count();
    }

    private static boolean is369DigitChar(char digit) {
        return Arrays.stream(ClapNumber.values())
                .anyMatch(clapNumber -> clapNumber.isEqual(digit));
    }

    private static char intToChar(int number) {
        return (char) number;
    }
}
