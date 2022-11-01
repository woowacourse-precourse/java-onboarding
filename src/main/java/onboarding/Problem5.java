package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import onboarding.problem5.MoneyParser;


public class Problem5 {
    public static List<Integer> solution(int money) {
        MoneyParser parser = new MoneyParser(50000,10000,5000,1000,500,100,50,10,1);
        return parser.parseMoney(money);
    }
}
