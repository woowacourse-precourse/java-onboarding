package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return getMoneyQuantity(money);
    }

    // 돈 단위별 수량 구하는 메소드
    public static List<Integer> getMoneyQuantity(int money) {
        int[] moneyType = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> moneyQuantity = new ArrayList<>();
        for (int i : moneyType) {
            moneyQuantity.add(money / i);
            money %= i;
        }
        return moneyQuantity;
    }
}