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
			mul = Arrays.stream(numList).parallel().reduce(0, (a, b) -> a * b);
			max = Math.max(Math.max(add, mul), max);
		}
		return max;
	}

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;
		return answer;
	}
}
