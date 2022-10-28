package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    private static void calculate(List<Integer> answer, int money) {
        int items[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int item : items) {
            answer.add(money / item);
            money %= item;
        }
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        calculate(answer, money);
        return answer;
    }
}
