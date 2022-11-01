package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return withdraw(money);
    }

    static List<Integer> withdraw(int money) {
        List<Integer> exchange = new ArrayList<>();
        int[] unit={50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for(int i=0; i<unit.length; i++){
            exchange.add(money/unit[i]);
            money%=unit[i];
        }
        return exchange;
    }
}