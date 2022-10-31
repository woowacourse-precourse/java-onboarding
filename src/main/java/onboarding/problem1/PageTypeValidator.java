package onboarding.problem1;

import java.util.List;

public class PageTypeValidator {
	private final int DIFFERENCE = 1;
	private final int LEFT_NUMBER = 0;
	private final int RIGHT_NUMBER = 1;
	private final int SECOND = 2;
	private final int LEFT_ODD_AND_EVEN = 1;
	private final int RIGHT_ODD_AND_EVEN = 0;

	public boolean validate(List<Integer> list) {

		return list.get(RIGHT_NUMBER) - list.get(LEFT_NUMBER) == DIFFERENCE
			&& list.get(LEFT_NUMBER) % SECOND == LEFT_ODD_AND_EVEN
			&& list.get(RIGHT_NUMBER) % SECOND == RIGHT_ODD_AND_EVEN;
	}
}
