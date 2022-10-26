package onboarding;

import onboarding.problem1.CompareResult;
import onboarding.problem1.Player;

import java.util.List;

class Problem1 {
    private static final Integer ERROR_NUMBER = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            return new CompareResult().compare(new Player(pobi), new Player(crong));
        } catch (Exception e) {
            return ERROR_NUMBER;
        }
    }
}