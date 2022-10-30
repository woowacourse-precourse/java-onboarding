package onboarding.problem1;

import java.util.List;

public class PageValidator {
	public boolean validate(List<Integer> list) {
		PageTypeValidator pageTypeValidator = new PageTypeValidator();
		PageRangeValidator pageRangeValidator = new PageRangeValidator();
		return pageRangeValidator.validate(list) && pageTypeValidator.validate(list);
	}
}
