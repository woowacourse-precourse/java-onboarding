package onboarding.problem1.vo;

import java.util.List;
import java.util.stream.Collectors;

public class Page {
	private final Integer pageNumber;

	private Page(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public static Page of(Integer pageNumber) {
		return new Page(pageNumber);
	}

	public Integer getNumber() {
		return pageNumber;
	}

	public List<Integer> getEachNumberList() {
		return pageNumber
			.toString().chars()
			.map(ascii -> ascii - 48)
			.boxed().collect(Collectors.toList());
	}
}
