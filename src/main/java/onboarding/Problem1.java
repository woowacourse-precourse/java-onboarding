package onboarding;

import java.util.List;
import onboarding.problem1.Comparator;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        answer = Comparator.compareUsers(pobi, crong);
        return answer;
    }
}
