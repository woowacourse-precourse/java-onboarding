package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static final int MAX_VALUE_OF_MONEY = 1_000_000;

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        try {
            validateInputSize(money);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        return answer;
    }

    private static void validateInputSize(int money) {
        if (money < 1 || money > MAX_VALUE_OF_MONEY) {
            throw new IllegalArgumentException("허용되지 않는 크기의 입력값입니다.");
        }
    }
}
