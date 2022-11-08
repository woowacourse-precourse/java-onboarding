package onboarding;

import onboarding.problem1.domain.Calculator;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Calculator calculator = new Calculator();
        return calculator.compareScore(pobi, crong);
    }
}