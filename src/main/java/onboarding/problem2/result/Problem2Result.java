package onboarding.problem2.result;

import onboarding.problem.ProblemResult;

public class Problem2Result implements ProblemResult<String> {

	private final String plainText;

	public Problem2Result(String plainText) {
		this.plainText = plainText;
	}

	@Override
	public String toResult() {
		return plainText;
	}
}
