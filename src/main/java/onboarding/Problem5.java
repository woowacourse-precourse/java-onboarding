package onboarding;

import java.util.List;
import java.util.ArrayList;


public class Problem5 {

    static int[] cash = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {

        List<Integer> money_to_cash = new ArrayList<>();

        for(int i=0; i<cash.length; i++){
            money_to_cash.add(money / cash[i]);
            money %= cash[i];
        }

        return money_to_cash;
    }
}
