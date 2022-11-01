package onboarding;

import java.util.ArrayList;
import java.util.List;
import onboarding.problem5.ChangeBill;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        ChangeBill changeBill = new ChangeBill(money);
        answer = changeBill.changeBills();
        return answer;
    }
}
