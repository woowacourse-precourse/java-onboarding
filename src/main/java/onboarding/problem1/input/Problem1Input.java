package onboarding.problem1.input;

import onboarding.problem.ProblemInput;
import onboarding.problem1.domain.PagePair;

import java.util.List;

public class Problem1Input implements ProblemInput {

	private static final int LAST_PAGE = 400;

	private static final int FIRST_PAGE = 1;

	private final PagePair pobiPagePair;

	private final PagePair crongPagePair;

	public Problem1Input(List<Integer> pobi, List<Integer> crong) {
		this.pobiPagePair = new PagePair(pobi);
		this.crongPagePair = new PagePair(crong);
	}

	public PagePair pobiPagePair() {
		return pobiPagePair;
	}

	public PagePair crongPagePair() {
		return crongPagePair;
	}

	@Override
	public boolean hasError() {
		// 범위를 벗어난 페이지가 없는지 확인
		if (crongPagePair.isOutOfRange(FIRST_PAGE, LAST_PAGE)
				|| pobiPagePair.isOutOfRange(FIRST_PAGE, LAST_PAGE)) {
			return true;
		}
		// 연속된 두 숫자이며 [홀수 - 짝수]인지 확인
		return crongPagePair.isNotConsecutiveOddEven()
				|| pobiPagePair.isNotConsecutiveOddEven();
	}
}
