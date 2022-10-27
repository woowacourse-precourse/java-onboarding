package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new java.util.ArrayList<>(Collections.emptyList());

        int[] moneyKinds = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int left = money;

        for(int i=0; i<9; i++){

            int moneyKind = moneyKinds[i];

            if (left >= moneyKind){
                int count = left/moneyKind;
                answer.add(count);
                left = left%moneyKind;
            }
            else {
                answer.add(0);
            }
        }
        return answer;
    }

}
