package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        validate(money);
        return new ArrayList<>();
    }

    private static void validate(int money) {
        if (money < 1 || money > 1_000_000) {
            throw new IllegalArgumentException("유효하지 않은 금액입니다.");
        }
    }
}
