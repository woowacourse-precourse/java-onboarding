package onboarding;

public class Problem3 {
    public static final char THREE = '3';
    public static final char SIX = '6';
    public static final char NINE = '9';
    public static final int CLAP = 1;
    public static final int NO_CLAP = 0;

    public static int solution(int number) {;
        return calculateClapCount(number);
    }

    private static int calculateClapCount(int number) {
        int clapCount = NO_CLAP;
        for (int i = 1; i <= number; i++) {
            clapCount += find369(i);
        }
        return clapCount;
    }

    private static int find369(int number) {
        int clapCount = NO_CLAP;
        char[] digits = tearDownToDigits(number);
        for (char digit : digits) {
            clapCount += clapWhenContains369(digit);
        }
        return clapCount;
    }

    private static char[] tearDownToDigits(int number) {
        return String.valueOf(number).toCharArray();
    }

    private static int clapWhenContains369(char digit) {
        if (isContains369(digit)) {
            return CLAP;
        }
        return NO_CLAP;
    }

    private static boolean isContains369(char digit) {
        return digit == THREE || digit == SIX || digit == NINE;
    }
}
