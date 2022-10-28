package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    static class Wallet {
        static final int MONEY_MAX_COUNT = 9;

        private List<Integer> money = new ArrayList<>(MONEY_MAX_COUNT);
        private int[] currency = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        private int target;

        public Wallet(int target) {
            this.target = target;
        }

        private void calculate() {
            int tmp = target;
            for(int i=0 ; i<MONEY_MAX_COUNT ; i++){
                money.add(tmp / currency[i]);
                tmp%=currency[i];
            }
        }

    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }
}
