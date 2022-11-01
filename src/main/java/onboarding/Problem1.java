package onboarding;

import java.util.List;
import onboarding.problem1.Comparator;
import onboarding.problem1.Validation;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (!Validation.validate(pobi, crong)) {
            answer = -1;
        }
        if (answer != -1) {
            answer = Comparator.compareUsers(pobi, crong);
        }
        return answer;
    }
}
