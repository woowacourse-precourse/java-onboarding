package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    static int [] moneyTypes = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = withdraw(money);
        return answer;
    }

    public static List<Integer> withdraw(int money) {
        List<Integer> bundle = new ArrayList<>();

        for (int won : moneyTypes) {
            bundle.add(money / won);
            money %= won;
        }

        return bundle;
    }
}
