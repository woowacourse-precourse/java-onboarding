package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        try {
            isValidMoney(money);
        } catch (IllegalStateException moneyIsNotValidException) {
            moneyIsNotValidException.printStackTrace();
        }

        return answer;
    }

    public static void isValidMoney(int money) throws IllegalStateException {
        if (money < 1 || money > 1000000)
            throw new IllegalStateException("money의 범위가 올바르지 않습니다.");
    }
}
