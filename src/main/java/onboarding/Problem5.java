package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        int[] cashes = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for(int i = 0; i < cashes.length; i++){
            if(money/cashes[i] != 0){
                answer.add(money/cashes[i]);
                money -= (money/cashes[i] * cashes[i]);
            } else {
                answer.add(0);
            }
        }

        return answer;
    }
}
