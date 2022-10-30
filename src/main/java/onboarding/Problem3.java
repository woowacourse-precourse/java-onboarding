package onboarding;

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
                .filter(Problem3::is369DigitChar)
                .count();
    }

    private static boolean is369DigitChar(int digit) {
        if (digit == '3' || digit == '6' || digit == '9') {
            return true;
        }
        return false;
    }
}
