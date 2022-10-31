package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0);
        int[] moneyList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i = 0; i < 9; i++) {
            answer.set(i, money / moneyList[i]);
            money = money - moneyList[i] * answer.get(i);
        }
        return answer;
    }
}