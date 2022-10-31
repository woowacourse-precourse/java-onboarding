package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0));
        List<Integer> bills = List.of(50000,10000,5000,1000,500,100,50,10,1);

        for (int i=0 ; i<bills.size() ; i++) {
            answer.set(i, money / bills.get(i));
            money %= bills.get(i);
        }

        return answer;
    }
}
