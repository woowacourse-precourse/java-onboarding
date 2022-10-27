package onboarding;

import onboarding.problem5.Atm;
import onboarding.problem5.ChangesList;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        Atm atm = new Atm(new ChangesList());
        return atm.withdraw(money);
    }
}
