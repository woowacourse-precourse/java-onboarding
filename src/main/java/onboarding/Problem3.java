package onboarding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem3 {
    static final int LEFT_PAGE_BOUNDARY = 1;
    static final int RIGHT_PAGE_BOUNDARY = 10000;
    static final int RADIX = 10;

    private static final Set<Integer> numbers369 = new HashSet<>(Arrays.asList(3, 6, 9));
    public static int solution(int number) {
        int answer = 0;

        if (number<LEFT_PAGE_BOUNDARY || number>RIGHT_PAGE_BOUNDARY) {
            return answer;
        }

        for (int i=3; i<=number; i++) {
            answer += count396(i);
        }
        return answer;
    }

    private static int count396(int num) {
        int count = 0;
        int remainder;
        while (num>0) {
            remainder = num%RADIX;
            if (numbers369.contains(remainder)) {
                count++;
            }
            num /= RADIX;
        }
        return count;
    }
}
