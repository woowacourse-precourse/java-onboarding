package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {
	public static int getScore(List<Integer> pageList) {
		int max = Integer.MIN_VALUE;
		int[] numList;
		int add;
		int mul;

		for (int page : pageList) {
			String number = String.valueOf(page);
			numList = Stream.of(number.split("")).mapToInt(Integer::parseInt).toArray();
			add = Arrays.stream(numList).sum();
			mul = Arrays.stream(numList).parallel().reduce(1, (a, b) -> a * b);
			max = Math.max(Math.max(add, mul), max);
		}
		return max;
	}

	public static boolean isInvalid(List<Integer> pageList) {
		int left = pageList.get(0);
		int right = pageList.get(1);

		if ((left >= 3 && left <= 397) && (right >= 4 && right <= 398)) {
			return (right - left) != 1 || left % 2 == 0;
		}
		return true;
	}

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer;

		if (isInvalid(pobi) || isInvalid(crong)) {
			answer = -1;
			return answer;
		}

		int pobiScore = getScore(pobi);
		int crongScore = getScore(crong);

		if (pobiScore > crongScore) {
			answer = 1;
		} else if (pobiScore < crongScore) {
			answer = 2;
		} else {
			answer = 0;
		}

		return answer;
	}
}
