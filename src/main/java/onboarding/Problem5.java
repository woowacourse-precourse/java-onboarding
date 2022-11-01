package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    private static int[] korCurrency = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    static class Wallet {
        private static final int MONEY_MAX_COUNT = 9;

        private List<Integer> money = new ArrayList<>(MONEY_MAX_COUNT);
        private int target;

        public Wallet(int target) {
            this.target = target;
        }

        List<Integer> getTotalMoney() {
            calculate();
            return money;
        }

        private void calculate() {
            int tmp = target;
            for(int i=0 ; i<MONEY_MAX_COUNT ; i++){
                money.add(tmp / korCurrency[i]);
                tmp%= korCurrency[i];
            }
        }

    }
    public static List<Integer> solution(int money) {
        Wallet wallet = new Wallet(money);
        return wallet.getTotalMoney();
    }
}
