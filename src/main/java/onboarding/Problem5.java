package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
   public static List<Integer> solution(int money) {
       final int[] MONEY_LIST = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
       List<Integer> answer = new ArrayList<>();
        for (int u : MONEY_LIST) {
            answer.add(exchangeMoney(money , u));
            money = divideMoney(money, u);
        }
        return answer;
    }

    public static int divideMoney(int money, int unit) {
        return money % unit;
    }

    public static int exchangeMoney(int money, int unit) {
        return money / unit;
    }
}
