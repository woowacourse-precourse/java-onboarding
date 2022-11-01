package onboarding;

import java.util.*;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer,Integer> moneyUnit = new HashMap<>();

        moneyUnit.put(0,50000);
        moneyUnit.put(1,10000);
        moneyUnit.put(2,5000);
        moneyUnit.put(3,1000);
        moneyUnit.put(4,500);
        moneyUnit.put(5,100);
        moneyUnit.put(6,50);
        moneyUnit.put(7,10);
        moneyUnit.put(8,1);

        for (int i=0; i<9; i++) {
            int division = money / moneyUnit.get(i);
            money -= division * moneyUnit.get(i);
            answer.add(division);
        }

        return answer;
    }
}
