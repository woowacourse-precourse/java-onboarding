package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        int[] money_list = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for(int i = 0; i < money_list.length; i++){
            answer.add(i, money / money_list[i]);
            money = money - (money / money_list[i] * money_list[i]);
        }

        return answer;
    }
}
