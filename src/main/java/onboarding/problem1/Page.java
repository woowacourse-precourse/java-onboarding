package onboarding.problem1;

import java.util.List;

public class Page {
	private static final Integer MAX_PAGE = 400;
	private static final Integer MIN_PAGE = 1;

	private Integer left;
	private Integer right;

	public Page(List<Integer> page) {
		if (verifyPage(page)) {
			this.left = page.get(0);
			this.right = page.get(1);
		} else {
			throw new RuntimeException("Page 생성에 실패했습니다.");
		}
	}

	private boolean verifyPage(List<Integer> page) {
		Integer left = page.get(0);
		Integer right = page.get(1);

		if ((left >= MIN_PAGE && right <= MAX_PAGE)
				&& (left % 2 == 1 && right == left + 1)) {
			return true;
		} else {
			return false;
		}
	}

	public Integer getLeft() {
		return left;
	}

	public Integer getRight() {
		return right;
	}
}
