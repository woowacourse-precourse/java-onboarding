package onboarding.problem3.result;

import onboarding.problem.ProblemResult;

public class Problem3Result implements ProblemResult<Integer> {

	private final int clapCount;

	public Problem3Result(int clapCount) {
		this.clapCount = clapCount;
	}

	@Override
	public Integer toResult() {
		return clapCount;
	}
}
