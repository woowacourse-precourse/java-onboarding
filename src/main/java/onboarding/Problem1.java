package onboarding;

import onboarding.problem1.input.Problem1Input;
import onboarding.problem1.result.Problem1Result;
import onboarding.problem1.solver.Problem1Solver;

import java.util.List;

class Problem1 {

    private static final int EXCEPTION_RESULT = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Problem1Input input = new Problem1Input(pobi, crong);

        if (input.hasError()) {
            return EXCEPTION_RESULT;
        }

        Problem1Solver solver = new Problem1Solver();

        Problem1Result result = solver.solve(input);
        return result.toResult();
    }
}