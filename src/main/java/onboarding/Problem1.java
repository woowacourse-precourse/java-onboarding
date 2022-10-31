package onboarding;

import java.util.List;
import onboarding.problem1.PageGamePlayService;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        return PageGamePlayService.play(pobi, crong);
    }
}