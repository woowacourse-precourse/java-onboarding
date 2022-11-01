package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> moneyList = List.of(50000,10000,5000,1000,500,100,50,10);

        for (Integer m : moneyList) {
            answer.add(money/m);
            money %= m;
        }

        answer.add(money);
        return answer;
    }
}
