package onboarding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem3 {
    private static final Set<Integer> numbers369 = new HashSet<>(Arrays.asList(3, 6, 9));
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static int count396(int num) {
        int count = 0;
        int remainder;
        while (num>0) {
            remainder = num%10;
            if (numbers369.contains(remainder)) {
                count++;
            }
            num /= 10;
        }
        return count;
    }
}
