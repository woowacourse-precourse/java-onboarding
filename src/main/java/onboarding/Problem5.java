package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> result = new ArrayList<>();
        result.add(money / 50000);
        money %= 50000;
        result.add(money / 10000);
        money %= 10000;
        result.add(money / 5000);
        money %= 5000;
        result.add(money / 1000);
        money %= 1000;
        result.add(money / 500);
        money %= 500;
        result.add(money / 100);
        money %= 100;
        result.add(money / 50);
        money %= 50;
        result.add(money / 10);
        money %= 10;
        result.add(money);

        return result;
    }
}
