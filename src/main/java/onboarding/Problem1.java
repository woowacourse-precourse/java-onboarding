package onboarding;

import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer;

		int pobiLeftNum = pobi.get(0);
		int pobiRightNum = pobi.get(1);
		int crongLeftNum = crong.get(0);
		int crongRightNum = crong.get(1);

		// 예외처리
		if (pobiLeftNum < 1 || pobiRightNum > 400 ||
			crongLeftNum < 1 || crongRightNum > 400 ||
			pobiLeftNum % 2 != 1 || pobiRightNum % 2 != 0 ||
			crongLeftNum % 2 != 1 || crongRightNum % 2 != 0 ||
			pobiRightNum - pobiLeftNum != 1 ||
			crongRightNum - crongLeftNum != 1) {
			return -1;
		}

		int finalPobiNum = Math.max(getMaxNum(pobiLeftNum), getMaxNum(pobiRightNum));
		int finalCrongNum = Math.max(getMaxNum(crongLeftNum), getMaxNum(crongRightNum));

		if (finalPobiNum > finalCrongNum) {
			answer = 1;
		} else if (finalPobiNum < finalCrongNum) {
			answer = 2;
		} else {
			answer = 0;
		}

		return answer;
	}

	/**
	 * 주어진 숫자에서 각 자리의 수를 더하거나, 곱해서 큰 수를 찾는 방법
	 */
	public static int getMaxNum(int page) {
		int result;
		int plus = 0;
		int multi = 1;

		String changeToString = Integer.toString(page);

		for (int i = 0; i < changeToString.length(); i++) {
			plus += Integer.parseInt(changeToString.split("")[i]);
			multi *= Integer.parseInt(changeToString.split("")[i]);
		}
		result = Math.max(plus, multi);
		return result;
	}

}