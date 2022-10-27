package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		PageComparator comparator = new PageComparator();

		if (comparator.verifyPage(pobi) && comparator.verifyPage(crong)) {
			Integer pobiMaxValue = comparator.getMaxPageValue(pobi);
			Integer crongMaxValue = comparator.getMaxPageValue(crong);


			return 1; // 승자 리턴
		} else {
			return -1;
		}
	}
}

class PageComparator {

	public boolean verifyPage(List<Integer> page) {
		Integer left = page.get(0);
		Integer right = page.get(1);

		if (left % 2 == 1 && right == left + 1) {
			return true;
		} else {
			return false;
		}
	}

	public Integer getMaxPageValue(List<Integer> page) {
		Integer left = page.get(0);
		Integer right = page.get(1);

		return Math.max(getMaxValue(left), getMaxValue(right));
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
