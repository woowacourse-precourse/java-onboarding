package onboarding;

import java.util.Collections;
import java.util.List;
import onboarding.problem05.entity.Money;

public class Problem5 {
    public static List<Integer> solution(int money) {
        Money classifiedMoney = Money.from(money);
        List<Integer> answer = classifiedMoney.processing();
        return answer;
    }
}
