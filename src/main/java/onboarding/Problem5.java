package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }
}

class Money {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 1000000;
    private static final String NOT_ALLOWED_UNDER_MIN_RANGE = "money는 1 이상의 자연수입니다.";
    private static final String NOT_ALLOWED_OVER_MAX_RANGE = "money는 1000000 이하의 자연수입니다.";
    private final int money;

    public Money(int money) {
        validateMoneyRange(money);
        this.money = money;
    }

    private void validateMoneyRange(int money) {
        if (money < MIN_RANGE) {
            throw new IllegalStateException(NOT_ALLOWED_UNDER_MIN_RANGE);
        }
        if (money > MAX_RANGE) {
            throw new IllegalStateException(NOT_ALLOWED_OVER_MAX_RANGE);
        }
    }

    private int changeMoney(Money moneyUnit) {
        return this.money / moneyUnit.money;
    }
}

