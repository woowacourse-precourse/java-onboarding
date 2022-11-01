package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Problem1 {

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		try {
			validatePageList(pobi);
			validatePageList(crong);
			int pobiMax = calculateMaxValue(pobi);
			int crongMax = calculateMaxValue(crong);
			int answer = compareTwoNumbers(pobiMax, crongMax);
			return answer;
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}

	public static int calculateMaxValue(List<Integer> pageList) {
		List<Integer> resultList = new ArrayList<>();
		for (int num : pageList) {
			resultList.add(sumEveryDigits(num));
			resultList.add(multipleEveryDigits(num));
		}
		int result = Collections.max(resultList);
		return result;
	}

	static int sumEveryDigits(int num) {
		List<Integer> digitList = splitDigits(num);
		int result = digitList.stream().mapToInt(Integer::intValue).sum();
		return result;
	}

	static int multipleEveryDigits(int num) {
		List<Integer> digitList = splitDigits(num);
		int result = 1;
		for (int i : digitList) {
			result *= i;
		}
		return result;
	}

	static List<Integer> splitDigits(int num) {
		List<Integer> result = Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt)
			.boxed().collect(Collectors.toList());
		return result;
	}

	static int compareTwoNumbers(int num1, int num2) {
		if (num1 > num2) {
			return 1;
		}
		if (num1 < num2) {
			return 2;
		}
		return 0;
	}

	static void validatePageList(List<Integer> pageList) throws Exception {
		validateAllPageNumber(pageList);
		validateStartOrEndPage(pageList);
		validateGap(pageList);
		validateLength(pageList);
	}

	static void validateAllPageNumber(List<Integer> pageList) throws Exception {
		for (int pageNumber : pageList) {
			validatePageNumber(pageNumber);
		}
	}

	static void validatePageNumber(int pageNumber) throws Exception {
		if (pageNumber < 1) {
			throw new Exception("페이지 수가 너무 작습니다");
		}
		if (pageNumber > 400) {
			throw new Exception("페이지 수가 너무 큽니다");
		}
	}

	static void validateGap(List<Integer> pageList) throws Exception {
		int gap = pageList.get(1) - pageList.get(0);
		if (gap != 1) {
			throw new Exception("붙어있지 않은 페이지");
		}
	}

	static void validateLength(List<Integer> pageList) throws Exception {
		int length = pageList.size();
		if (length != 2) {
			throw new Exception("페이지 수가 3개 이상입니다");
		}
	}

	static void validateStartOrEndPage(List<Integer> pageList) throws Exception {
		int leftPageNumber = pageList.get(0);
		int rightPageNumber = pageList.get(1);
		if (leftPageNumber == 1 || rightPageNumber == 400) {
			throw new Exception("첫 장 또는 마지막 장을 열었습니다");
		}
	}
}