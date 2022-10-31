package onboarding;

import java.util.List;

class Problem1 {

	// 포비와 크롱의 승부 결과를 출력하는 메소드
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		if (!isAllValid(pobi) || !isAllValid(crong)) {
			return -1;
		}

		int pobiMax = maxPageNumber(pobi);
		int crongMax = maxPageNumber(crong);

		if (pobiMax < crongMax) {
			return 2;
		}

		if (pobiMax > crongMax) {
			return 1;
		}

		if (pobiMax == crongMax) {
			return 0;
		}

		return -1;
	}

	// 매개변수의 유효성을 검증하는 메소드
	private static boolean isAllValid(List<Integer> pages) {
		if (!isSizeValid(pages)) {
			return false;
		}

		if (!ContainStartOrEnd(pages)) {
			return false;
		}

		if (!isPageNumberValid(pages)) {
			return false;
		}

		if (!isContinuous(pages)) {
			return false;
		}

		if (!isNotZero(pages)) {
			return false;
		}

		if (!isPositive(pages)) {
			return false;
		}

		if (!isBookSizeValid(pages)) {
			return false;
		}

		return true;
	}

	// 입력받은 페이지 수 크기가 2인지 확인하는 메소드
	private static boolean isSizeValid(List<Integer> pages) {
		return pages.size() == 2;
	}

	// 페이지에 시작 면, 마지막 면이 포함되어 있는지 검증하는 메소드
	private static boolean ContainStartOrEnd(List<Integer> pages) {
		return !pages.contains(1) && !pages.contains(2) && !pages.contains(399) && !pages.contains(400);
	}

	// 왼쪽, 오른쪽 페이지가 각각 짝수 홀수인지 검증하는 메소드
	private static boolean isPageNumberValid(List<Integer> pages) {
		return pages.get(0) % 2 != 0 && pages.get(1) % 2 == 0;
	}

	// 왼쪽, 오른쪽 페이지가 연속되지 않는 경우를 확인하는 메소드
	private static boolean isContinuous(List<Integer> pages) {
		return pages.get(1) - pages.get(0) == 1;
	}

	// 페이지가 0이 아닌 경우를 검증하는 메소드
	private static boolean isNotZero(List<Integer> pages) {
		return pages.get(0) != 0 && pages.get(1) != 0;
	}

	// 페이지가 양수인 경우를 검증하는 메소드
	private static boolean isPositive(List<Integer> pages) {
		return pages.get(0) > 0 && pages.get(1) > 0;
	}

	// 책 사이즈를 검증하는 메소드
	private static boolean isBookSizeValid(List<Integer> pages) {
		if (pages.get(0) >= 3 && pages.get(0) <= 398) {
			return true;
		}

		if (pages.get(1) >= 3 && pages.get(1) <= 398) {
			return true;
		}

		return false;
	}

	// 왼쪽, 오른쪽 페이지에서 각 자리 수를 더하거나 곱해 가장 큰 수를 반환하는 메소드
	private static int maxPageNumber(List<Integer> pages) {
		int max = 0;

		for (Integer page : pages) {
			int pageNumber = maxNumber(page);

			if (pageNumber > max) {
				max = pageNumber;
			}
		}

		return max;
	}

	// 페이지의 각 자리 수를 더하거나 곱해 가장 큰 수를 반환하는 메소드
	private static int maxNumber(int page) {
		int sum = add(page);
		int multiplication = multiply(page);

		return Math.max(sum, multiplication);
	}

	// 페이지의 각 자리 숫자를 모두 곱하는 메소드
	private static int multiply(int page) {
		int multiplication = 1;
		String num = String.valueOf(page);

		for (int i = 0; i < num.length(); i++) {
			char c = num.charAt(i);
			multiplication *= Character.getNumericValue(c);
		}

		return multiplication;
	}

	// 페이지의 각 자리 숫자를 모두 더하는 메소드
	private static int add(int page) {
		int sum = 0;
		String num = String.valueOf(page);

		for (int i = 0; i < num.length(); i++) {
			char c = num.charAt(i);
			sum += Character.getNumericValue(c);
		}

		return sum;
	}

}