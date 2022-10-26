package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    
    private static int getMaxSum(final List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Problem1::sum)
                .max()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("올바른 값이 아닙니다.");
                });
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