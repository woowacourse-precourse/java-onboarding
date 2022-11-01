package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        Integer[] divideMoney = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        ArrayList answer = new ArrayList<>();
        for (int i = 0; i < divideMoney.length; i++) {
            answer.add(money / divideMoney[i]);
            money %= divideMoney[i];
        }

        return answer;
    }
}
