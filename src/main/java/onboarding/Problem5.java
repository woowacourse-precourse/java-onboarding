package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        final int[] moneyUnit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int count;

        for(int i=0; i<moneyUnit.length; i++) {
            count = 0;
            if(money >= moneyUnit[i]) {
                count = money / moneyUnit[i];
                money -= count * moneyUnit[i];
            }
            answer.add(count);
        }
        return answer;
    }
}
