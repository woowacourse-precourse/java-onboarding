package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new java.util.ArrayList<>(Collections.emptyList());

        int[] moneyList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for(int i = 0; i < moneyList.length; i++){
            answer.add(money/moneyList[i]);
            money %= moneyList[i];
        }

        return answer;
    }
}
