package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    static final List<Integer> kindOfMoney = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {

        List<Integer> result = withdraw(money);

        return result;
    }

    static List<Integer> withdraw(int money) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < kindOfMoney.size(); i++) {

            result.add(money / kindOfMoney.get(i));

            money %= kindOfMoney.get(i);
        }

        return result;
    }
}
