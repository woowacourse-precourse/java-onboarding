package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(Collections.emptyList());
        List<Integer> moneyList = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        for(int i=0; i < 9 ; i++){
            answer.add(0);
        }

        int moneyCount = 0;
        for(int i=0; i < 9; i++){
            if(moneyList.get(i) <= money) {
                moneyCount = answer.get(i) + (money / moneyList.get(i));
                answer.set(i, moneyCount);
                money %= moneyList.get(i);
            }
            if(money == 0) break;
        }
        return answer;
    }
}
