package onboarding;

import service.problem1.Problem1Service;
import java.util.List;

class Problem1 {
    private static final Problem1Service service = new Problem1Service();

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        return service.getWinner(pobi, crong);
    }
}