package onboarding;

import onboarding.problem5.SolveMoneyChange;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        SolveMoneyChange solveMoneyChange = new SolveMoneyChange();
        List<Integer> answer = Collections.emptyList();
        answer = solveMoneyChange.changeMoney(money);
        return answer;
    }
}
