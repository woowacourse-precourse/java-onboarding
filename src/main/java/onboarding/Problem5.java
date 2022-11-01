package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] moneyUnit = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i = 0; i < moneyUnit.length; i++){
            if(i == 0){
                answer.add(i, (money/ moneyUnit[i]));
            } else {
                answer.add(i, (money % moneyUnit[i-1]) / moneyUnit[i]);
            }
        }
        return answer;
    }
}
