package onboarding;

import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;

		if (checkRestrictions(pobi) == -1 || checkRestrictions(crong) == -1) {
			return -1;
		}

		int pobiScore = calcPageNumberScore(pobi);
		int crongScore = calcPageNumberScore(crong);

		answer = compareScores(pobiScore, crongScore);

		return answer;
	}

	/**
	 * 점수를 비교해 알맞은 값을 리턴하는 메서드
	 * @param pobiScore
	 * @param crongScore
	 * @return
	 */
	private static int compareScores(int pobiScore, int crongScore) {
		int answer;
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
	 * @return
	 */
	private static int calcPageNumberScore(List<Integer> pages) {
		int pageSum = 0;
		int pageMultiplication = 1;
		int greater = 0;
		int score = -1;
		int singleDigit = 0;

		for (Integer page : pages) {
			while (page > 0) {
				singleDigit = page % 10;
				pageSum += singleDigit;
				pageMultiplication *= singleDigit;
				greater = Math.max(pageSum, pageMultiplication);
				page /= 10;
			}
			if (greater > score) {
				score = greater;
			}
		}
		return score;
	}
}
