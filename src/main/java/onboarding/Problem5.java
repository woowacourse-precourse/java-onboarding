package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int totalMoney = money;
        int[] moneyTypes = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> answer = new ArrayList<>(9);

        for (int type : moneyTypes) {
            answer.add(totalMoney/type);
            totalMoney %= type;
        }

        return answer;
    }
}
