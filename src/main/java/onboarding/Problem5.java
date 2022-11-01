package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {
    private static final int MIN_WITHDRAWABLE_MONEY = 1;
    private static final int MAX_WITHDRAWABLE_MONEY = 1000000;
    private static final int[] MONETARY = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    private static final List<Integer> MONETARY_UNITS = Arrays.stream(MONETARY).boxed().collect(
        Collectors.toList());
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }
    private static int getShare(int numerator, int denominator) {
        return numerator / denominator;
    }
    private static int getRemainder(int numerator, int denominator) {
        return numerator % denominator;
    }
    private static void validateWithdrawnMoney(int money) {
        if (money < MIN_WITHDRAWABLE_MONEY || money > MAX_WITHDRAWABLE_MONEY) {
            throw new IllegalArgumentException("1원 이상 1,000,000원 이하만 출금 가능합니다");
        }
    }
}
