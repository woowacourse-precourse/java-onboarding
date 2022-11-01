package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        List<Integer> moneyChange = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        for(int i=0; i<moneyChange.size(); i++){
            answer.add(money / moneyChange.get(i));
            money = money % moneyChange.get(i);
        }

        return answer;
    }
}
