package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    public static int divideMoney(int money) {
        money %= 50000;
        money %= 10000;
        money %= 5000;
        money %= 1000;
        money %= 500;
        money %= 100;
        money %= 50;
        money %= 10;
        money %= 1;
        return money;
    }
}
