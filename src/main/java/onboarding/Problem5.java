package onboarding;

import onboarding.p5.AutomatedTellerMachine;

import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return AutomatedTellerMachine.getBills(money);
    }
}
