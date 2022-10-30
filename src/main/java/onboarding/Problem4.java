package onboarding;

import onboarding.problem4.input.Problem4Input;
import onboarding.problem4.result.Problem4Result;
import onboarding.problem4.solver.Problem4Solver;

public class Problem4 {

    public static String solution(String word) {
        Problem4Input input = new Problem4Input(word);
        Problem4Solver solver = new Problem4Solver();

        Problem4Result result = solver.solve(input);
        return result.toResult();
    }
}
