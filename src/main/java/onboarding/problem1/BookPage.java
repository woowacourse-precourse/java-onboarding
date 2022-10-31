package onboarding.problem1;

import java.util.List;

public class BookPage implements Comparable<BookPage>{

	private final PageNum left;
	private final PageNum right;

	public BookPage(List<Integer> input) {
		validateInput(input);
		this.left = new PageNum(input.get(0));
		this.right = new PageNum(input.get(1));
	}

	void validateInput(List<Integer> input) {
		if (input.size() != 2 || !isOdd(input.get(0)) || input.get(0) + 1 != input.get(1)) {
			throw new IllegalArgumentException("잘못된 페이지입니다.");
		}
	}

	boolean isOdd(int left) {
		return left % 2 != 0;
	}

	public int getScore() {
		return Math.max(left.getScore(), right.getScore());
	}


	@Override
	public int compareTo(BookPage o) {
		return this.getScore() - o.getScore();
	}
}
