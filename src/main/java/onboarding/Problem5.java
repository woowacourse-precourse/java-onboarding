package onboarding;

import onboarding.problem5.Change;

import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        Change change = new Change();
        return change.getChanges(money);
    }
}
