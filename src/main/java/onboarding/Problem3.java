package onboarding;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem3 {
	public static int solution(int number) {
		int answer = 0;
		if (!restrictions(number)) {
			answer = clapCount(number);
		}

		return answer;
	}

	static boolean restrictions(int number) {
		if (1 > number || 10000 < number) {
			return true;
		}
		return false;
	}

	static int clapCount(int number) {
		int count = 0;
		for (int i = 1; i <= number; i++) {
			count += eachNumClapCount(i);
		}
		return count;

	}

	static int eachNumClapCount(int num) {
		int count = 0;
		int[] numSplit = numberSplit(num);
		for (int i = 0; i < numSplit.length; i++) {
			if (isExist369(numSplit[i])) {
				count++;
			}
		}
		return count;
	}

	static int[] numberSplit(int number) {
		int[] numSplit = Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).toArray();
		return numSplit;
	}

	static boolean isExist369(int i) {
		int[] samyukguArr = { 3, 6, 9 };
		boolean isExist = IntStream.of(samyukguArr).anyMatch(x -> x == i);
		return isExist;
	}
	
}
