package onboarding;

import onboarding.problem5.Changes;

import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return new Changes(money).changes();
    }
}
