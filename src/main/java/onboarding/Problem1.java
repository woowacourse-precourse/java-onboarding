package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;

		// 예외처리
		if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
			return -1;
		}

		// 포비 더하기
		int pobiLeftResult = 0;
		int pobiRightResult = 0;
		int pobiLeft = pobi.get(0);
		int pobiRight = pobi.get(1);

		while (pobiLeft > 0) {
			pobiLeftResult += pobiLeft % 10;
			pobiLeft /= 10;
		}

		while (pobiRight > 0) {
			pobiRightResult += pobiRight % 10;
			pobiRight /= 10;
		}

		int pobiPlus = Math.max(pobiLeftResult, pobiRightResult);

		// 포비 곱하기
		pobiLeftResult = 1;
		pobiRightResult = 1;
		pobiLeft = pobi.get(0);
		pobiRight = pobi.get(1);

		while (pobiLeft > 0) {
			pobiLeftResult *= pobiLeft % 10;
			pobiLeft /= 10;
		}

		while (pobiRight > 0) {
			pobiRightResult *= pobiRight % 10;
			pobiRight /= 10;
		}

		int pobiMul = Math.max(pobiLeftResult, pobiRightResult);

		// 최종 포비 결과값
		int pobiResult = Math.max(pobiPlus, pobiMul);

		return answer;
	}
}
