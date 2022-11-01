package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    // list for cost of currency
    private static List<Integer> currency = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
    // func : calculate amount of each currency, return List
    private static List<Integer> calculate(int money){
        List<Integer> cnt = new ArrayList<>();

        // count currency cnt and reassign money
        for (int i=0;i<currency.size();i++){
            int amount = currency.get(i);
            cnt.add(money / amount);
            money %= amount;
        }
        return cnt;
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = calculate(money);
        return answer;
    }
}
