package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    public static List<Integer> solution(int money) {
        checkValidRange(money);
        Money remainMoney = new Money();
        List<Integer> answer = remainMoney.getMoney(money);;

        return answer;
    }

    private static void checkValidRange(final int money) {
        if (money < 1 || money > 1000000) {
            throw new IllegalArgumentException();
        }
    }

    static class Money{
        private static final int[] MONEY_LIST = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        private final List<Integer> money;

        public Money() {
            this.money = new ArrayList<>();
        }
        public List<Integer> getMoney(int money) {
            for (int i = 0; i < MONEY_LIST.length; i++) {
                money = getRemainMoney(money, i);
            }
            return this.money;
        }

        private int getRemainMoney(int money, int index) {
            int count = 0;
            if (money >= MONEY_LIST[index]) count = money / MONEY_LIST[index];
            money = money - MONEY_LIST[index] * count;
            this.money.add(count);
            return money;
        }
    }

}
