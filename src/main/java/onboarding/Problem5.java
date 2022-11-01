package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    private enum LocalCurrency{
        FIVE_MILLION_BILL(50000),
        ONE_MILLION_BILL(10000),
        FIVE_THOUSAND_BILL(5000),
        ONE_THOUSAND_BILL(1000),
        FIVE_HUNDRED_BILL(500),
        ONE_HUNDRED_BILL(100),
        FIFTY_BILL(50),
        TEN_BILL(10),
        ONE_BILL(1);

        private final int money;

        LocalCurrency(int money){
            this.money = money;
        }
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        for (LocalCurrency localCurrency : LocalCurrency.values()){
            answer.add(money / localCurrency.money);
            money %= localCurrency.money;
        }
        return answer;
    }
}
