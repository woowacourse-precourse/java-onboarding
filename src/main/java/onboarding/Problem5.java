package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Problem5 {
    private static final List<Integer> MONETARY_UNITS = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 1000000;
    public static List<Integer> solution(int money) {
        validityChecker(money);

        return getAnswer(money);
    }

    private static void validityChecker(int money) {
        if (!isValidateMoney(money)) {
            throw new IllegalArgumentException("Not valid money");
        }
    }
    private static boolean isValidateMoney(int money) {
        return MIN_NUMBER <= money && money <= MAX_NUMBER;
    }
    private static List<Integer> getAnswer(int money) {
        List<Integer> answer = new ArrayList<>();
        for (int monetaryUnit : MONETARY_UNITS) {
            answer.add(money / monetaryUnit);
            money %= monetaryUnit;
        }
        return answer;
    }
}