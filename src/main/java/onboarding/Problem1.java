package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    
    private static int sum(final int number) {
        return Arrays.stream(split(number))
                .mapToInt(Integer::parseInt)
                .sum();
    }
    
    private static String[] split(final int number) {
        return String.valueOf(number).split("");
    }
}