package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] moneyArr = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for(int i = 0; i < moneyArr.length; i++) {
            int quotient = 0;
            if(money >= moneyArr[i]) {
                quotient = money / moneyArr[i];
                money = money % moneyArr[i];
            }
            answer.add(quotient);
        };

        return answer;
    }
}
