package onboarding;

import onboarding.problem3.input.Problem3Input;
import onboarding.problem3.result.Problem3Result;
import onboarding.problem3.solver.Problem3Solver;

public class Problem3 {
    public static int solution(int number) {
        Problem3Input input = new Problem3Input(number);
        Problem3Solver solver = new Problem3Solver();

        Problem3Result result = solver.solve(input);
        return result.toResult();
    }
}
