package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        while (money >= 10) {
            int i = 50000;
            while (i >= 10) {
                answer.add(money / i);
                money %= i;
                i /= 5;
                answer.add(money / i);
                money %= i;
                i /= 2;
            }
        }
        answer.add(money);

        return answer;
    }
}
