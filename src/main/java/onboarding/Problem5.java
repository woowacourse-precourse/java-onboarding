package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = changeMoney(money);
        return answer;
    }

    private static List<Integer> changeMoney(int money) {
        List<Integer> moneys = new ArrayList<Integer>();

        int[] digitMoney = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for(int digit : digitMoney) {
            moneys.add(money / digit);
            money%=digit;
        }

        return moneys;
    }
}
