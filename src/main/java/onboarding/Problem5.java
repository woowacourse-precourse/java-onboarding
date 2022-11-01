package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {

    private static final int MIN_MONEY = 1;
    private static final int MAX_MONEY = 1000000;

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        validateMoney(money);
        return answer;
    }

    private static void validateMoney(int money) throws IllegalArgumentException {
        if (!isValidMoneyRange(money)) {
            throw new IllegalArgumentException(String.format("올바른 범위의 값은 %d - %d입니다.", MIN_MONEY, MAX_MONEY));
        }
    }

    private static boolean isValidMoneyRange(int money) {
        return (MIN_MONEY <= money) && (money <= MAX_MONEY);
    }
}
