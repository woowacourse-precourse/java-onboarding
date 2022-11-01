package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        List<Integer> money_list = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        for (int i = 0; i < money_list.toArray().length; i++) {
            int count = money / money_list.get(i);
            money -= count * money_list.get(i);
            money_list.set(i, count);
        }//for
        answer = money_list;
        return answer;
    }
}
