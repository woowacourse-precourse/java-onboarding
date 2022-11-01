package onboarding;

import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        ExchangeUtils exchangeUtils = new ExchangeUtils();
        return exchangeUtils.exchangeMoney(money);
    }
}
