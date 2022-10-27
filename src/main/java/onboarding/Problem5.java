package onboarding;

import onboarding.problem5.domain.Money;

import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return new Money(money).numberOfEachCurrency();
    }
}
