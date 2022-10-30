package onboarding.problem3.solver;

import onboarding.problem.Solver;
import onboarding.problem3.domain.Number;
import onboarding.problem3.domain.NumberCounter;
import onboarding.problem3.input.Problem3Input;
import onboarding.problem3.result.Problem3Result;

import java.util.List;

public class Problem3Solver implements Solver<Problem3Input, Problem3Result> {

	@Override
	public Problem3Result solve(Problem3Input input) {
		NumberCounter counter = new NumberCounter(List.of(3, 6, 9));
		Number number = input.number();

		int clapCount = counter.count(number);
		return null;
	}
}
