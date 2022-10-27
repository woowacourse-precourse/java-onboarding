package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        // 50_000
        answer.add(money / 50_000);
        money %= 50_000;

        // 10_000
        answer.add(money / 10_000);
        money %= 10_000;

        // 5_000
        answer.add(money / 5_000);
        money %= 5_000;

        // 1_000
        answer.add(money / 1_000);
        money %= 1_000;

        // 500
        answer.add(money / 500);
        money %= 500;

        // 100
        answer.add(money / 100);
        money %= 100;

        // 50
        answer.add(money / 50);
        money %= 50;

        // 10
        answer.add(money / 10);
        money %= 10;

        // 1
        answer.add(money);

        return answer;
    }

}
