package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        int[] moneyArr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < moneyArr.length; i++) {
            if (money==0) {
                answer.add(0);
                continue;
            }
            answer.add(money / moneyArr[i]);
            money %= moneyArr[i];
        }

        return answer;
    }
}
