package onboarding;

import java.util.List;

/**
 * 1. 입력 값을 검증한다. (left 는 홀수, right 는 left + 1 인 짝수여야 한다.)
 * 2. left, right 값의 자릿수의 합, 곱을 구한다.
 * 3. left, right 의 합, 곱 중 가장 큰 값을 구한다.
 * 4. 점수를 비교하여 결과를 나타낸다.
 */
class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		PageComparator comparator = new PageComparator();

		if (comparator.verifyPage(pobi) && comparator.verifyPage(crong)) {

			return 1; // 승자 리턴
		} else {
			return -1;
		}
	}
}

class PageComparator {

	boolean verifyPage(List<Integer> page) {
		Integer left = page.get(0);
		Integer right = page.get(1);

		if (left % 2 == 1 && right == left + 1) {
			return true;
		} else {
			return false;
		}
	}
}
