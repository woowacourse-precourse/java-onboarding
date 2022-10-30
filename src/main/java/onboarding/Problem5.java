package onboarding;

import onboarding.problem5.input.Problem5Input;
import onboarding.problem5.result.Problem5Result;
import onboarding.problem5.solver.Problem5Solver;

import java.util.List;

public class Problem5 {

    public static List<Integer> solution(int money) {
        Problem5Input input = new Problem5Input(money);
        Problem5Solver solver = new Problem5Solver();

        Problem5Result result = solver.solve(input);
        return result.toResult();
    }
}
