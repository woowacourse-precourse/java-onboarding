package onboarding;

import onboarding.problem5.service.MoneyUnitCountService;

import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return MoneyUnitCountService.getUnitCount(money);
    }
}
