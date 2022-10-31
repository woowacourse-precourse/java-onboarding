package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> cost = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        int num = 0;

        if(money > 1000000){
            answer = List.of(0, 0, 0, 0, 0, 0, 0, 0, 0);
            return answer;
        }

        while(num < 9){
            answer.add(money/cost.get(num));
            money -= (money/cost.get(num))*cost.get(num);
            num ++;
        }
        return answer;
    }
}
