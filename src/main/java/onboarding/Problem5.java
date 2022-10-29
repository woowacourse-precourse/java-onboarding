package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    private static final int MONEY_MIN = 1;
    private static final int MONEY_MAX = 1000000;

    private static final List<Integer> changeList = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {
        validateMoney(money);
        List<Integer> answer = new ArrayList<>();

        for (int change : changeList) {
            int changeCount = money / change;

            answer.add(changeCount);
            money -= (changeCount * change);
        }
        return answer;
    }

    private static void validateMoney(int money) {
        if (money < MONEY_MIN || money > MONEY_MAX) {
            throw new IllegalArgumentException();
        }
    }

}
