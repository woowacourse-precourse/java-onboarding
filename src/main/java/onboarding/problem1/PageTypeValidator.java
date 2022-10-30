package onboarding.problem1;

import java.util.List;

public class PageTypeValidator {
	public static final int DIFFERENCE = 1;
	public static final int FIRST = 1;
	public static final int SECOND = 0;

	public boolean validate(List<Integer> list) {
		return list.get(FIRST) - list.get(SECOND) == DIFFERENCE;
	}
}
