package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> monetaryUnit = new ArrayList<>(Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));

        for (int i = 0; i < monetaryUnit.size(); i++) {
            if (money >= monetaryUnit.get(i)) {
                answer.add(i, money / monetaryUnit.get(i));
                money = money % monetaryUnit.get(i);
            } else {
                answer.add(i, 0);
            }
        }
        return answer;
    }
}
