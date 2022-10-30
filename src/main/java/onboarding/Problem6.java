package onboarding;

import onboarding.problem6.input.Problem6Input;
import onboarding.problem6.result.Problem6Result;
import onboarding.problem6.solver.Problem6Solver;

import java.util.List;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        Problem6Input input = new Problem6Input(forms);
        Problem6Solver solver = new Problem6Solver();

        Problem6Result result = solver.solve(input);
        return result.toResult();
    }
}
