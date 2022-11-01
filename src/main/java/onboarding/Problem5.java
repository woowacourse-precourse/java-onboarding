package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] moneys = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 };
        for(int mon : moneys){
            if(money >= mon){
                answer.add(money/mon);
                money %= mon;
            }
            else answer.add(0);
        }
        return answer;
    }
}