package onboarding;

import onboarding.support.problem5.Money;

import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        Money answer = new Money(money);
        return answer.getMoneyList();
    }
}
