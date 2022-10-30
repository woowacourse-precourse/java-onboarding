package onboarding;

import onboarding.problem7.input.Problem7Input;
import onboarding.problem7.result.Problem7Result;
import onboarding.problem7.solver.Problem7Solver;

import java.util.Collections;
import java.util.List;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Problem7Input input = new Problem7Input(user, friends, visitors);
        Problem7Solver solver = new Problem7Solver();

        Problem7Result result = solver.solve(input);
        return result.toResult();
    }
}
