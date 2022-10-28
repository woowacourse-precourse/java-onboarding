package onboarding;

import java.util.Arrays;

public class Problem3 {

    private static final int[] CLAP_COND_DIGITS = {3, 6, 9};

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static int clapCountAtNumber(int number) {
        int count = 0;
        int tmp = number;
        while (tmp >= 1) {
            if (clapCond(tmp % 10))
                count++;
            tmp /= 10;
        }
        return count;
    }

    private static boolean clapCond(int digit) {
        return Arrays.stream(CLAP_COND_DIGITS).anyMatch(num -> digit == num);
    }
}
