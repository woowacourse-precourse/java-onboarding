package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    static List<Integer> countAmount(int money) {
        int[] amount = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        ArrayList<Integer> countMoney = new ArrayList<> ();

        for (int i : amount) {
            countMoney.add(money / i);
            money %= i;
        }

        return countMoney;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        answer = countAmount(money);

        return answer;
    }
}
