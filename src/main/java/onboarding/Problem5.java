package onboarding;

import java.util.*;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

 List<Integer> moneyList = new ArrayList<Integer>();

        moneyList.add(money / 50000);
        money %= 50000;

        moneyList.add(money / 10000);
        money %= 10000;

        moneyList.add(money / 5000);
        money %= 5000;

        moneyList.add(money / 1000);
        money %= 1000;

        moneyList.add(money / 500);
        money %= 500;

        moneyList.add(money / 100);
        money %= 100;

        moneyList.add(money / 50);
        money %= 50;

        moneyList.add(money / 10);
        money %= 10;

        moneyList.add(money);

        answer = moneyList;

        
        return answer;
    }
}
