package onboarding;

import java.util.ArrayList;
import java.util.List;

import onboarding.validatechecker.Problem5ValidateChecker;

public class Problem5 {
    private static final List<Integer> CURRENCY_TYPE = List.of(50000,10000,5000,1000,500,100,50,10,1);

    public static List<Integer> solution(int money) {
        Problem5ValidateChecker.isNumberInRange(money);
        List<Integer> answer = new ArrayList<>();

        for (Integer currency : CURRENCY_TYPE) {
            answer.add(money / currency);
            money = money % currency;
        }

        return answer;
    }
}
