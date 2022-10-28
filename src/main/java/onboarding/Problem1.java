package onboarding;

import static onboarding.problem1.GameCalculator.calculateGameResult;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        return calculateGameResult(pobi, crong);
    }
}