package onboarding;

import java.util.List;

public class BookPage {

	private final PageNum left;
	private final PageNum right;

	public BookPage(List<Integer> input) {
		validateInput(input);
		this.left = new PageNum(input.get(0));
		this.right = new PageNum(input.get(1));
	}

	void validateInput(List<Integer> input) {
		if (input.size() != 2 || !isOdd(input.get(0)) || !isEven(input.get(1))) {
			throw new IllegalStateException("페이지가 잘못 되었습니다.");
		}
	}

	boolean isOdd(int left) {
		return left % 2 != 0;
	}

	boolean isEven(int right) {
		return right % 2 == 0;
	}
}
