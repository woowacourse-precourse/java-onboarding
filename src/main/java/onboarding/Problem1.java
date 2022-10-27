package onboarding;

import utils.Problem1Util;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiResult = Problem1Util.getMaxBetweenSumAndMultiply(pobi);
        int crongResult = Problem1Util.getMaxBetweenSumAndMultiply(crong);
        return Problem1Util.whoIsWinner(pobiResult, crongResult);
    }
}