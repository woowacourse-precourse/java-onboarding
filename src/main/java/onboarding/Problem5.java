package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        Integer[] moneyList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> answer = new ArrayList<>(moneyList.length);

        for(int i = 0; i < moneyList.length; i++){
            int amount = moneyList[i];
            int quot = money / amount; //몫
            answer.add(quot);
            money %= amount;
        }

        return answer;
    }

}

