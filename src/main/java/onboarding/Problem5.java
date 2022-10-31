package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = new ArrayList<>();
        int unit = 50000;

        for(int i = 0; i < 9; i++) {
            answer.add(money/unit);
            money = money % unit;
            if(i%2 == 0)
                unit /= 5;
            else if (i != 7)
                unit /= 2;
            else
                unit = 1;
        }

        return answer;
    }
}
