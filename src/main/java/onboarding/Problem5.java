package onboarding;

import onboarding.problem5.MoneyCalculator;

import java.util.Collections;
import java.util.List;

/**
 * Problem 5 function list
 * - Count each unit's number
 */
public class Problem5 {
    public static List<Integer> solution(int money) {
        MoneyCalculator calculator = new MoneyCalculator(money);
        return calculator.calculate();
    }
}
