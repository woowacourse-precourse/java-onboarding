package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] changemoneys = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for(int i =0; i<changemoneys.length; i++){
            if(money/changemoneys[i] !=0){
                answer.add(money/changemoneys[i]);
                money = money % changemoneys[i];
            }
            else if(money/changemoneys[i] == 0){
                answer.add(0);
            }
        }

        return answer;
    }
}
