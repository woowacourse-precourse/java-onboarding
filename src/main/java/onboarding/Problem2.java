package onboarding;

import onboarding.problem2.input.Problem2Input;
import onboarding.problem2.result.Problem2Result;
import onboarding.problem2.solver.Problem2Solver;

public class Problem2 {

    public static String solution(String cryptogram) {
        Problem2Input input = new Problem2Input(cryptogram);
        Problem2Solver solver = new Problem2Solver();

        Problem2Result result = solver.solve(input);
        return result.toResult();
    }
}
