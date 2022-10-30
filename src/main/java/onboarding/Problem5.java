package onboarding;

import java.util.Collections;
import java.util.List;
import onboarding.problem5.Atm;
import onboarding.problem5.WonAtm;

public class Problem5 {
    public static List<Integer> solution(int money) {
        Integer[] cachTypes = {50000,10000,5000,1000,500,100,50,10,1};
        Atm atm = new WonAtm(cachTypes);
        return atm.exchange(money);
    }
}
