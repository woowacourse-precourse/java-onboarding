package onboarding.problem2.solver;

import onboarding.problem.Solver;
import onboarding.problem2.domain.Cryptogram;
import onboarding.problem2.domain.Decoder;
import onboarding.problem2.input.Problem2Input;
import onboarding.problem2.result.Problem2Result;

public class Problem2Solver implements Solver<Problem2Input, Problem2Result> {

	@Override
	public Problem2Result solve(Problem2Input input) {
		Cryptogram cryptogram = input.cryptogram();
		Decoder decoder = new Decoder();

		String result = decoder.decode(cryptogram);
		return new Problem2Result(result);
	}
}
