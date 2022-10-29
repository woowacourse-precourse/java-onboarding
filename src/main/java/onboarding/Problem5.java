package onboarding;

import java.util.Collections;
import java.util.List;
import onboarding.problem5.Bank;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = Bank.getResult(money);
        return answer;
    }
}
