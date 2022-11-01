package onboarding;

import service.problem1.Problem1Serviceable;
import service.problem1.Problem1ServiceImpl;
import java.util.List;

class Problem1 {
    private static final Problem1Serviceable service = new Problem1ServiceImpl();

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        return service.getWinner(pobi, crong);
    }
}