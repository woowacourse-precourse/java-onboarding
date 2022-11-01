package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        int targetMoney = money;
        List<Integer> coins = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10);
        int coinsCount = coins.size()-1;

        for(int index = 0; index <= coinsCount; index++) {
            int value = targetMoney / coins.get(index);
            targetMoney = targetMoney % coins.get(index);
            answer.add(value);

            if(index == 7) {
                answer.add(targetMoney);
            }

        }

        return answer;
    }
}
