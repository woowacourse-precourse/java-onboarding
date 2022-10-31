package onboarding;

import problem5.MoneyChanger;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        try {
            return MoneyChanger.change(money);
        } catch (RuntimeException e) {
            return null;
        }
    }
}
