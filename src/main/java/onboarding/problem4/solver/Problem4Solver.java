package onboarding.problem4.solver;

import onboarding.problem.Solver;
import onboarding.problem4.domain.Word;
import onboarding.problem4.input.Problem4Input;
import onboarding.problem4.result.Problem4Result;

public class Problem4Solver implements Solver<Problem4Input, Problem4Result> {

    @Override
    public Problem4Result solve(Problem4Input input) {
        Word word = input.word();
        Word reverse = word.reverse();
        return new Problem4Result(reverse);
    }
}
