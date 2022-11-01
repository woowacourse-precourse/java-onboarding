package onboarding;

import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int number) {
        Money money = new Money(number);
        return money.transformMoney();
    }
}
