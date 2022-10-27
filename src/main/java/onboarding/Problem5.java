package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> coins = new ArrayList<>(Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));

        for (int i = 0; i < coins.size(); i++) {
            if (money >= coins.get(i)) {
                answer.add(i, money / coins.get(i));
                money = money % coins.get(i);
            } else {
                answer.add(i, 0);
            }
        }
        return answer;
    }
}
