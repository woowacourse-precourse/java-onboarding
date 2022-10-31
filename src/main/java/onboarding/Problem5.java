package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] monetaryUnit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int wonBill = 0;

        for (int i=0; i<monetaryUnit.length; i++) {
            wonBill = money/monetaryUnit[i];
            money = money%monetaryUnit[i];
            answer.add(wonBill);
        }

        return answer;
    }
}
