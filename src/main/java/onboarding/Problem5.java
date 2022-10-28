package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        int[] bills = new int[9];
        bills[0] = 50000;
        bills[1] = 10000;
        bills[2] = 5000;
        bills[3] = 1000;
        bills[4] = 500;
        bills[5] = 100;
        bills[6] = 50;
        bills[7] = 10;
        bills[8] = 1;

        for(int idx = 0; idx < 9; idx++) {
            answer.add(money / bills[idx]);
            money %= bills[idx];
        }
        return answer;
    }
}
