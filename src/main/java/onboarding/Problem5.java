package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    private static final int MIN_MONEY = 1;
    private static final int MAX_MONEY = 1000000;

    public static List<Integer> solution(int money) {
        if (isOutOfNumber(money)) {
            throw new IllegalArgumentException("유효한 돈의 범위를 입력해주세요. (1 ~ 1,000,000원)");
        }
        return getChangeUnits(money);
    }

    private static List<Integer> getChangeUnits(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] changes = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int change : changes) {
            answer.add(money / change);
            money %= change;
        }

        return answer;
    }

    private static boolean isOutOfNumber(int money) {
        return money < MIN_MONEY || money > MAX_MONEY;
    }
}
