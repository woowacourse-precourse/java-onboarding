package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(Collections.emptyList());
        List<Integer> moneyList = new ArrayList<Integer>();

        moneyList.add(50000);
        moneyList.add(10000);
        moneyList.add(5000);
        moneyList.add(1000);
        moneyList.add(500);
        moneyList.add(100);
        moneyList.add(50);
        moneyList.add(10);
        moneyList.add(1);

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
