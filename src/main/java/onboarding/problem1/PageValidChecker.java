package onboarding.problem1;

import java.util.Arrays;
import java.util.List;

public class PageValidChecker {
	private final int lastPage;

	public PageValidChecker(int lastPage) {
		this.lastPage = lastPage;
	}

	private boolean checkValidRange(List<Integer> user) {
		return user.stream().allMatch(p -> p >= 1 && p <= lastPage);
	}

	private boolean checkValidPage(List<Integer> user) {
		List<Integer> invalidPages = Arrays.asList(1, lastPage);
		return !user.stream().anyMatch(invalidPages::contains)
			&& (user.get(1) - user.get(0)) == 1
			&& ((user.get(0) % 2) == 1) && ((user.get(1) % 2) == 0);
	}

	public boolean checkValid(List<Integer> user) {
		return checkValidRange(user) && checkValidPage(user);
	}

}
