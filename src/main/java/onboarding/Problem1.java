package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		PageComparator comparator = new PageComparator();

		try {
			Page pobiPage = new Page(pobi);
			Page crongPage = new Page(crong);

			Integer pobiMaxValue = comparator.getMaxPageValue(pobiPage);
			Integer crongMaxValue = comparator.getMaxPageValue(crongPage);

			return comparator.compare(pobiMaxValue, crongMaxValue);
		} catch (Exception e) {
			System.out.println("Exception - PROBLEM1: " + e.getMessage());
			return -1;
		}

	}

	static class Page {

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

	static class PageComparator {

		public Integer getMaxPageValue(Page page) {
			Integer left = page.getLeft();
			Integer right = page.getRight();

			return Math.max(getMaxValue(left), getMaxValue(right));
		}

		public Integer compare(Integer value1, Integer value2) {
			if (value1 > value2) {
				return 1;
			} else if (value1 < value2) {
				return 2;
			} else {
				return 0;
			}
		}

		private Integer getMaxValue(Integer page) {
			List<Integer> numberList = new ArrayList<>();

			while (page > 0) {
				numberList.add(page % 10);
				page = page / 10;
			}

			Integer sumValue = numberList.stream().reduce(0, (sum, value) -> sum + value);
			Integer multipleValue = numberList.stream().reduce(1, (sum, value) -> sum * value);

			return Math.max(sumValue, multipleValue);
		}
	}
}
