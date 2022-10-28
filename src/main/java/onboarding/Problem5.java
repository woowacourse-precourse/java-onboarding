package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    static final int MIN_MONEY = 1;
    static final int MAX_MONEY = 1000000;
    static final List<Integer> ERROR = Collections.emptyList();
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        if (!isValidInput(money)) {
            answer = ERROR;
            return answer;
        }
        return answer;
    }

    private static boolean isValidInput(int money) {
        return isValidRange(money);
    }

    private static boolean isValidRange(int money) {
        return money >= MIN_MONEY && money <= MAX_MONEY;
    }
}
