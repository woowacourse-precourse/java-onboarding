package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> type_money = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        for(int price : type_money) {
            answer.add(money / price);
            money = money % price;
        }

        return answer;
    }
}
