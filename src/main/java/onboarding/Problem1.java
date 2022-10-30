package onboarding;

import onboarding.problem1.input.Problem1Input;

import java.util.List;

class Problem1 {

    private static final int EXCEPTION_RESULT = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Problem1Input input = new Problem1Input(pobi, crong);
        if (input.hasError()) {
            return EXCEPTION_RESULT;
        }
        return 0;
    }
}