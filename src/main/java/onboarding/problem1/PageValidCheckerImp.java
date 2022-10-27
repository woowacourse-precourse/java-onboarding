package onboarding.problem1;

import java.util.List;

public class PageValidCheckerImp implements PageValidChecker {
	private static final int lastPage = 400;

	private boolean checkRange(List<Integer> user) {
		return user.stream().allMatch(p -> p >= 1 && p <= lastPage);
	}

	private boolean checkValidPage(List<Integer> user) {
		List<Integer> invalidPages = List.of(1, lastPage);
		return user.stream().noneMatch(invalidPages::contains);
	}

	private boolean checkOddEven(List<Integer> user) {
		return user.get(0) % 2 == 1 && user.get(1) % 2 == 0;
	}

	private boolean checkContinuity(List<Integer> user) {
		return user.get(1) - user.get(0) == 1;
	}

	public boolean checkValid(List<Integer> user) {
		return checkRange(user)
			&& checkValidPage(user)
			&& checkOddEven(user)
			&& checkContinuity(user);
	}

}
