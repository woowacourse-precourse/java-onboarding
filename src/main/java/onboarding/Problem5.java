package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        answer = new ArrayList<>();

        int moneyUnit;
        for(int i = 0; i < 9; i++) {
            int moneyCount = 0;
            moneyUnit = 50000/(int)(Math.pow(10, i/2));
            if(i%2 == 1)
                moneyUnit /= 5;
            if(i == 8)
                moneyUnit = 1;
            moneyCount = money/moneyUnit;
            money %= moneyUnit;
            answer.add(moneyCount);
        }
        return answer;
    }
}
