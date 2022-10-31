package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        Integer[] coins = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i = 0; i < coins.length; i++) {
            if(money/coins[i] > 0){
                answer.add(money/coins[i]);
                money -= (money/coins[i])*coins[i];
            }
            else{
                answer.add(0);
            }
        }

        return answer;
    }
}
