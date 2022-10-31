package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> moneyUnit = new ArrayList<Integer>(){{
            add(50000);
            add(10000);
            add(5000);
            add(1000);
            add(500);
            add(100);
            add(50);
            add(10);
            add(1);
        }};

        for(Integer unit : moneyUnit) {
            if (money < unit) {
                answer.add(Integer.valueOf(0));
                continue;
            }

            answer.add(Integer.valueOf(money / unit));
            money = money % unit;
        }

        return answer;
    }
}
