package onboarding;

import java.util.Collections;
import java.util.List;
import onboarding.problem5.Bank;
import onboarding.problem5.Validation;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        try {
            Validation.validate(money);
            answer = Bank.getResult(money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return answer;
    }
}
