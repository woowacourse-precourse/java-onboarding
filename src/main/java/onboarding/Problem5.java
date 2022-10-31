package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> money_list = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        List<Integer> answer = new java.util.ArrayList<>(Collections.emptyList());
        for(int i = 0; i < (int)money_list.size(); i++){
            System.out.println(money_list.get(i));
            answer.add(money / money_list.get(i));
            money %= money_list.get(i);
        }
        return answer;
    }
}
