package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static List<Integer> result = new ArrayList<>();
    private static List<Integer> coins= List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return MoneyNumber(money);
    }

    public static List<Integer> MoneyNumber(int money) {
        result.clear();
        if(!error(money)) {
            for (int i = 0; i < coins.size(); i++) {
                result.add(money / coins.get(i));
                money %= coins.get(i);
            }
        }
        return result;
    }

    public static boolean error(int money){
        if(money>=1&& money<1000000){
            return false;
        }
        return true;
    }
}
