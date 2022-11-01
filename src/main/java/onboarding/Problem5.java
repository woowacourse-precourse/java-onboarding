package onboarding;

import java.util.*;

public class Problem5 {
    public static final int[] MONEY = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < MONEY.length; i++) {
            answer.add(money / MONEY[i]);
            money %= MONEY[i];
        }
        return answer;
    }
}
