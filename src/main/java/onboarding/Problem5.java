package onboarding;

import java.util.ArrayList;

import java.util.List;
import onboarding.Problem5.*;
import onboarding.domain.problem5.CurrencyKOR;

public class Problem5 {
    public static List<Integer> solution(int money) {
        if (outOfRange(money))
            throw new IllegalArgumentException("money는 1이상 1000000이하의 자연수입니다.");
        List<Integer> answer = new ArrayList<>();
        for (CurrencyKOR currency : CurrencyKOR.values()){
            answer.add(currency.calculate(money));
            money = currency.getChange(money);
        }
        return answer;
    }

    private static boolean outOfRange(int money) {
        return money <1 && money > 1000000;
    }
}
