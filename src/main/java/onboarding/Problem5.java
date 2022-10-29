package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0);
        List<Integer> unit = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        while(money > 0) {
            for(int i = 0; i < unit.size(); i++) {
                if(money >= unit.get(i)) {
                    if(unit.get(i) == 1) {
                        answer.set(i, money);
                        money = 0;
                    } else {
                        answer.set(i, money / unit.get(i));
                        money %= unit.get(i);
                    }
                }
            }
        }

        return answer;
    }
}
