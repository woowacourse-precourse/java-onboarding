package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        Integer[] money_unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            Integer cnt = money / money_unit[i];
            answer.add(cnt);
            money %= money_unit[i];
        }

        return answer;
    }
}
