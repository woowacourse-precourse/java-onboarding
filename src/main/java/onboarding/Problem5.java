package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        List<Integer> answer = Collections.emptyList();
        int moneyCount = 0;
        int wonUnit[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i = 0; i < 9; i++){
            moneyCount = money / wonUnit[i];
            money = money % wonUnit[i];
//            answer.add(moneyCount);
            System.out.printf("%d %d %d \n", i, moneyCount, money);
        }
        return answer;
    }
}
