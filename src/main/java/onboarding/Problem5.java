package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static List<Integer> answer;
    public static List<Integer> solution(int money) {
        answer = new ArrayList<>();

        int[] coins = {50000,10000,5000,1000,500,100,50,10,1};

        for(int i=0;i<coins.length;i++){

            int quotient = money / coins[i];
            money = money % coins[i];

            answer.add(quotient);
        }

        return answer;
    }
}
