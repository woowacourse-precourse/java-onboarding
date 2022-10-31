package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static class Money {
        private static final int FIFTY_THOUSAND_WON = 50000;
        private static final int TEN_THOUSAND_WON = 10000;
        private static final int FIVE_THOUSAND_WON = 5000;
        private static final int THOUSAND_WON = 1000;
        private static final int FIVE_HUNDRED_WON = 500;
        private static final int HUNDRED_WON = 100;
        private static final int FIFTY_WON = 50;
        private static final int TEN_WON = 10;
        private static final int ONE_WON = 1;

        private final int money;
        private int value;
        private List<Integer> result = new ArrayList<>();

        public Money (int money) {
            validateMoney(money);
            this.money = money;
        }

        private void validateMoney(int money) {
            if (!(money >= 1) && !(money <= 1000000)) {
                throw new IllegalArgumentException("잘못된 입력값 입니다.");
            }
        }

        private void addResult(int won) {
            result.add(value / won);
            this.value = value - ((value/won) * won);
        }
        public List<Integer> getResult() {
            value = this.money;
            addResult(FIFTY_THOUSAND_WON);
            addResult(TEN_THOUSAND_WON);
            addResult(FIVE_THOUSAND_WON);
            addResult(THOUSAND_WON);
            addResult(FIVE_HUNDRED_WON);
            addResult(HUNDRED_WON);
            addResult(FIFTY_WON);
            addResult(TEN_WON);
            addResult(ONE_WON);
            return result;
        }
    }

    public static List<Integer> solution(int money) {
        return new Money(money).getResult();
    }
}
