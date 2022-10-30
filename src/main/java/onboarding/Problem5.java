package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0));
        List<Integer> moneyList = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        String numStr = String.valueOf(money);
        for (int i = 0; i < answer.size(); i++) {
            answer.set(i, money / moneyList.get(i));
            money %= moneyList.get(i);
        }
        return answer;
    }
}
