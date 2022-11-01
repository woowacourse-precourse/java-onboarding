package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    private static final int minLength = 1;
    private static final int maxLength = 1000000;
    private static final List<Integer> moneyList = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {
        isValidate(money);
        List<Integer> answer = getCountMoney(money);
        return answer;
    }

    private static List<Integer> getCountMoney(int money) {
        List<Integer> answer = new ArrayList<>();
        for (Integer unit : moneyList) {
            answer.add(money / unit);
            money %= unit;
        }
        return answer;
    }
    private static void isValidate(int money) {
        if (money < minLength || money > maxLength) {
            throw new IllegalArgumentException("숫자가 1이상 1000000이하 이어야합니다.");
        }
    }
}
