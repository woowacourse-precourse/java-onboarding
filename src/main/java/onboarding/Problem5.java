package onboarding;

import onboarding.problem5.PennyGame;

import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return PennyGame.start(money);
    }
}
