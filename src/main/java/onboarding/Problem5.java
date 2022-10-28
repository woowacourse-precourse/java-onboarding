package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    private static final Integer MONEY_MINIMUM_LENGTH = 1;
    private static final Integer MONEY_MAXIMUM_LENGTH = 1000000;

    static List<Integer> answer;
    static int[] moneyArr;

    static void input() {
        answer = new ArrayList<>();
        moneyArr = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    }

    private static void validateMoney(int money) {
        if (money < MONEY_MINIMUM_LENGTH || money > MONEY_MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("money는 1 이상 1,000,000 이하인 자연수입니다.");
        }
    }

    private static void countMoney(int money) {
        for (int moneyPrice : moneyArr) {
            answer.add(money / moneyPrice);
            money = money % moneyPrice;
        }
    }

    public static List<Integer> solution(int money) {
        validateMoney(money);
        input();
        countMoney(money);
        return answer;
    }


}
