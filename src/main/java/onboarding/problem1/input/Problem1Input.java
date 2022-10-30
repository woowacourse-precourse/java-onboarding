package onboarding.problem1.input;

import onboarding.problem.ProblemInput;
import onboarding.problem1.domain.PagePair;

import java.util.List;

public class Problem1Input implements ProblemInput {

	private final PagePair pobiPagePair;

	private final PagePair crongPagePair;

	public Problem1Input(List<Integer> pobi, List<Integer> crong) {
		this.pobiPagePair = new PagePair(pobi);
		this.crongPagePair = new PagePair(crong);
	}

	@Override
	public boolean hasError() {
		return false;
	}
}
