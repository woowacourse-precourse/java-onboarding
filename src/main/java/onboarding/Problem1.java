package onboarding;

import onboarding.problem1.service.BookGameService;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        return BookGameService.result(pobi, crong);
    }
}
