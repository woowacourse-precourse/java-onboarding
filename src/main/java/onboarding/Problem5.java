package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        final int[] PAY_CASES = {50000,10000,5000,1000,500,100,50,10,1};

        for (int pay_case : PAY_CASES) {
            answer.add(money / pay_case);
            money = money % pay_case;
        }

        return answer;
    }



}
