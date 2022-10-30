package onboarding.problem1.solver;

import onboarding.problem.Solver;
import onboarding.problem1.domain.PagePair;
import onboarding.problem1.input.Problem1Input;
import onboarding.problem1.result.Problem1Result;

public class Problem1Solver implements Solver<Problem1Input, Problem1Result> {

    @Override
    public Problem1Result solve(Problem1Input input) {
        PagePair pobi = input.pobiPagePair();
        PagePair crong = input.crongPagePair();

        return new Problem1Result(
                pobi.totalScore(),
                crong.totalScore());
    }
}