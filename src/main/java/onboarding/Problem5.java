package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    private static List<Integer> moneys;

    public static List<Integer> solution(int money) {
        initMoneys();

        return countMoney(money);
    }

    private static void initMoneys() {
        moneys = new ArrayList<>(Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));
    }

    private static List<Integer> countMoney(int money) {
        List<Integer> answer = new ArrayList<>();
        for (Integer m : moneys) {
            answer.add(money / m);
            money %= m;
        }
        return answer;
    }
}