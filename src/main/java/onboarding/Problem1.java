package onboarding;

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

		// 크롱 더하기
		int crongLeftResult = 0;
		int crongRightResult = 0;
		int crongLeft = crong.get(0);
		int crongRight = crong.get(1);

		while (crongLeft > 0) {
			crongLeftResult += crongLeft % 10;
			crongLeft /= 10;
		}

		while (crongRight > 0) {
			crongRightResult += crongRight % 10;
			crongRight /= 10;
		}

		int crongPlus = Math.max(crongLeftResult, crongRightResult);

		// 크롱 곱하기
		crongLeftResult = 1;
		crongRightResult = 1;
		crongLeft = crong.get(0);
		crongRight = crong.get(1);

		while (crongLeft > 0) {
			crongLeftResult *= crongLeft % 10;
			crongLeft /= 10;
		}

		while (crongRight > 0) {
			crongRightResult *= crongRight % 10;
			crongRight /= 10;
		}

		int crongMul = Math.max(crongLeftResult, crongRightResult);

		// 최종 크롱 결과값
		int crongResult = Math.max(crongPlus, crongMul);

		// 결과값에 따른 answer 처리
		if (pobiResult > crongResult) {
			answer = 1;
		} else if (pobiResult < crongResult) {
			answer = 2;
		} else {
			answer = 0;
		}

		return answer;
	}
}
