package onboarding.problem1;

import java.util.ArrayList;
import java.util.List;

public class PageComparator {

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
