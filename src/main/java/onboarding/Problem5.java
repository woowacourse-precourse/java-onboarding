package onboarding;

import onboarding.problem5.Counter;
import onboarding.problem5.Validator;

import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        if(!Validator.validate(money)){
            return List.of(-1);
        }
        return Counter.countBills(money);
    }
}
