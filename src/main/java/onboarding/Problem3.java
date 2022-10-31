package onboarding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem3 {
    static final int minNum = 1;
    static final int maxNum = 10000;
    static final int RADIX = 10;

    private static final Set<Integer> number369 = new HashSet<>(Arrays.asList(3, 6, 9));
    public static int solution(int number) {
        int answer = 0;

        if (number< minNum || number> maxNum) {
            return answer;
        }

        for (int i=3; i<=number; i++) {
            answer += count396(i);
        }
        return answer;
    }

    private static int count396(int num) {
        int count = 0;
        int clap;
        while (num>0) {
            clap = num%RADIX;
            if (number369.contains(clap)) {
                count++;
            }
            num /= RADIX;
        }
        return count;
    }
}