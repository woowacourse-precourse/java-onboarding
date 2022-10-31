package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final Integer[] amount = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        return pay(money);
    }

    public static List<Integer> pay(int money){
        List<Integer> answer = new ArrayList<Integer>();
        for (int i = 0; i < amount.length; i++){
            int moneyCount = money / amount[i]; // greedy
            money %= amount[i];
            answer.add(moneyCount);
        }
        return answer;
    }
}
