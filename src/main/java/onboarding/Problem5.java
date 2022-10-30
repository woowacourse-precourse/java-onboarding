package onboarding;

import java.util.Collections;
import java.util.List;
import onboarding.prob5.domain.Banker;
import onboarding.prob5.domain.Coin;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        Banker banker = new Banker();
        answer = banker.solve(money);
        return answer;
    }
}
