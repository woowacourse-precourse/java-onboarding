package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        int[] price = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        while(money > 0){
            for(int n : price){
                answer.add(money/n);
                money =money%n;
            }
        }


        return answer;
    }
}
