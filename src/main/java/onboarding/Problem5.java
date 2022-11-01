package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    private static final String MESSAGE = "잘못된 입력입니다.";

    public static List<Integer> solution(int money) {
        if (!isInputValid(money)) {
            throw new IllegalArgumentException(MESSAGE);
        }

        return getMoneyBag(money);
    }

    private static boolean isInputValid(int money) {
        return money > 1 && money < 1000000;
    }

    private static List<Integer> getMoneyBag(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] bank = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i = 0; i < bank.length; i++) {
            answer.add(money / bank[i]);
            money %= bank[i];
        }
        return answer;
    }
}
