package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] moneys = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for(int coin : moneys){
            if(money >= coin){
                answer.add(money/coin);
                money%=coin;
            }
            else answer.add(0);
        }
        return answer;
    }
}
