package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;
		int pobiScore = -1;
		int crongScore = -1;

		if (checkRestrictions(pobi) == -1 || checkRestrictions(crong) == -1) {
			return -1;
		}

		pobiScore = calcPageNumberScore(pobi, pobiScore);
		crongScore = calcPageNumberScore(crong, crongScore);

		if (pobiScore == crongScore) {
			answer = 0;
		} else if (pobiScore > crongScore) {
			answer = 1;
		} else {
			answer = 2;
		}

		return answer;
	}

	/**
	 * 제한사항을 위배했는지 체크하는 메서드
	 * @param pages
	 * @return
	 */
	private static Integer checkRestrictions(List<Integer> pages) {
		int[] arr = pages.stream().mapToInt(i -> i).toArray();
		if (arr.length != 2) {
			return -1;
		}
		if (arr[1] - arr[0] != 1) {
			return -1;
		}
		return 0;
	}

	/**
	 * 한자리씩 쪼갠 숫자의 합과 곱을 계산하여 score 의 최댓값 갱신
	 * @param pages
	 * @param score
	 * @return
	 */
	private static int calcPageNumberScore(List<Integer> pages, int score) {
		for (Integer i : pages) {
			List<Integer> singleDigits = splitIntoSingleDigits(i);
			score = Math.max(score, addAllElements(singleDigits));
			score = Math.max(score, multiplyAllElements(singleDigits));
		}
		return score;
	}

	/**
	 * 숫자를 한자리씩 쪼개어 리스트로 반환하는 메서드
	 * @param num
	 * @return
	 */
	private static List<Integer> splitIntoSingleDigits(Integer num) {
		List<Integer> singleDigits = new ArrayList<>();
		while (num > 0) {
			singleDigits.add(num % 10);
			num /= 10;
		}
		return singleDigits;
	}

	/**
	 * 리스트의 요소를 모두 더하는 메서드
	 * @param singleDigits
	 * @return
	 */
	private static Integer addAllElements(List<Integer> singleDigits) {
		Integer result = 0;
		for (Integer integer : singleDigits) {
			result += integer;
		}
		return result;
	}

	/**
	 * 리스트의 요소를 모두 곱하는 메서드
	 * @param singleDigits
	 * @return
	 */
	private static Integer multiplyAllElements(List<Integer> singleDigits) {
		Integer result = 1;
		for (Integer integer : singleDigits) {
			result *= integer;
		}
		return result;
	}
}
