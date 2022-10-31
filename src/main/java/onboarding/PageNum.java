package onboarding;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class PageNum {

	private static final int LAST_PAGE_NUM = 400;
	private static final int START_PAGE_NUM = 1;
	private final int num;
	private final List<Integer> eachPageNumber;

	public PageNum(int pageNum) {
		validateNum(pageNum);
		this.num = pageNum;
		this.eachPageNumber = mapPageNumToList();
	}

	void validateNum(int pageNum) {
		if (pageNum >= LAST_PAGE_NUM || pageNum <= START_PAGE_NUM) {
			throw new IllegalArgumentException("페이지는 2~399 사이의 페이지를 펼쳐야합니다.");
		}
	}

	List<Integer> mapPageNumToList() {
		List<Integer> list = new LinkedList<>();
		int targetNum = num;
		while (targetNum > 0) {
			list.add(targetNum % 10);
			targetNum /= 10;
		}
		return list;
	}

	public int addEachPageNumber() {
		Optional<Integer> reduce = eachPageNumber.stream()
			.reduce(Integer::sum);
		if (reduce.isEmpty()) {
			return -1;
		}
		return reduce.get();
	}
}
