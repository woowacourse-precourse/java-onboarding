package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> wallet = new ArrayList<Integer>(9) {{
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
        for (int i = 0; i < 9; i++) {
            answer.add(money / wallet.get(i));
            money %= wallet.get(i);
        }

        return answer;
    }
}
