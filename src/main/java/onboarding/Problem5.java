package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        List<Integer> Money_Unit = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        int rest_money = money;
        for (int i = 0; i < Money_Unit.size(); i++){
            int num = rest_money / Money_Unit.get(i);
            answer.add(num);
            rest_money = rest_money % Money_Unit.get(i);
        }

        return answer;
    }
}
