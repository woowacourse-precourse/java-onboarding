package onboarding.problem5;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int number) {
        Money money = new Money(number);
        return money.transformMoney();
    }
}
