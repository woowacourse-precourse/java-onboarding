package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static final List<Integer> MONEY_UNIT = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 1000000;

    public static List<Integer> solution(int money) {
        validateRange(money);

        List<Integer> answer = new ArrayList<>();

        for (int moneyUnit : MONEY_UNIT) {
            answer.add(money / moneyUnit);
            money = money % moneyUnit;
        }

        return answer;
    }

    public static void validateRange(int number) {
        if (number < MINIMUM_NUMBER || MAXIMUM_NUMBER < number) {
            throw new IllegalArgumentException();
        }
    }
}
