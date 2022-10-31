package onboarding;

import java.util.Collections;
import java.util.List;

import onboarding.problemfive.domain.Wallet;

public class Problem5 {
    public static List<Integer> solution(int money) {

        List<Integer> answer = Wallet.put(money);
        return answer;
    }
}
