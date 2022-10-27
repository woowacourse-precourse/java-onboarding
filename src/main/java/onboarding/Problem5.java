package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        int[] moneyList = new int[] {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for(int coin : moneyList) {
            int numberOfMoney= money / coin;
            answer.add(numberOfMoney);
            money = money % coin;
            if(money <= 0) break;
        }
        return answer;
    }
}
