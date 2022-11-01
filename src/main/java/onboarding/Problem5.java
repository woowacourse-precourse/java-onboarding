package onboarding;

import java.util.Collections;
import java.util.List;
import onboarding.solution5.*;

public class Problem5 {
    public static List<Integer> solution(int money) {
        ChangeMoney change = new ChangeMoney();
        List<Integer> answer = change.changeMoney(money);
        return answer;
    }
}
