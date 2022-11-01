package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        int[] array = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> answer = new ArrayList<>(9);


        for(int i=0 ; i<9 ; i++) {
            if(money/array[i] > 0) {
                answer.add(money / array[i]);
                money %= array[i];
            }
            else answer.add(0);
        }

        return answer;
    }
}