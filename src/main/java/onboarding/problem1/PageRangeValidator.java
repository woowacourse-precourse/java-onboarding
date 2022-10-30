package onboarding.problem1;

import java.util.List;

public class PageRangeValidator {

	public static final int SIZE = 2;
	public static final int FIRST_NUMBER = 0;
	public static final int SECOND_NUMBER = 1;
	public static final int MIN_PAGE = 1;
	public static final int MAX_PAGE = 400;

	public boolean validate(List<Integer> list) {
		return list.size() == SIZE && list.get(FIRST_NUMBER) > MIN_PAGE && list.get(SECOND_NUMBER) < MAX_PAGE;
	}
}
