package onboarding;

import onboarding.support.problem5.Wallet;

import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        Wallet wa = new Wallet(money);
        return wa.getMoneyCounts();
    }
}
