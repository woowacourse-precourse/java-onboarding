package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        int[] currency = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        while(money > 0){
            for(int n : currency){
                answer.add(money/n);
                money %=n;
            }
        }
        
        return answer;
    }
}
