package onboarding;

import java.util.*;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        List<Integer> money_list = new ArrayList<Integer>();

        money_list.add(money / 50000);
        money %= 50000;

        money_list.add(money / 10000);
        money %= 10000;

        money_list.add(money / 5000);
        money %= 5000;

        money_list.add(money / 1000);
        money %= 1000;

        money_list.add(money / 500);
        money %= 500;

        money_list.add(money / 100);
        money %= 100;

        money_list.add(money / 50);
        money %= 50;

        money_list.add(money / 10);
        money %= 10;

        money_list.add(money);

        answer = money_list;

        return answer;
    }
}
