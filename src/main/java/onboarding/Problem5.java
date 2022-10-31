package onboarding;

import java.util.*;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(Collections.emptyList());
        List<Integer> moneyList = Arrays.asList(50000,10000,5000,1000,500,100,50,10,1);



        for (int i = 0;i<moneyList.toArray().length;i++){
            int div = moneyList.get(i);
            answer.add(money/div);
            money = money - (money/div)*div;

        }

        return answer;
    }
}
