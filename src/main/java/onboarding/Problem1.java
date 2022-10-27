package onboarding;

import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int pobiLeftPage = pobi.get(0);
		int pobiRightPage = pobi.get(1);
		int crongLeftPage = crong.get(0);
		int crongRightPage= crong.get(1);
		int result = 0;

		result = checkException(pobiLeftPage, pobiRightPage);
		if(result == -1) {
			return result;
		}
		result = checkException(crongLeftPage, crongRightPage);
		if(result == -1) {
			return result;
		}

		int pobiLeftSum = 0;
		int pobiRightSum = 0;
		int crongLeftSum = 0;
		int crongRightSum = 0;

		pobiLeftSum = calculateSum(pobiLeftPage, pobiLeftSum);
		pobiRightSum = calculateSum(pobiRightPage, pobiRightSum);
		crongLeftSum = calculateSum(crongLeftPage, crongLeftSum);
		crongRightSum = calculateSum(crongRightPage, crongRightSum);

		// int answer = Integer.MAX_VALUE;
		return result;
	}

	private static int checkException(int LeftPage, int RightPage) {
		if (LeftPage % 2 == 0 || RightPage % 2 == 1 ) {
			return  -1;
		}
		if(LeftPage +1 != RightPage) {
			return  -1;
		}
		if(LeftPage <= 1 || RightPage >= 400) {
			return  -1;
		}
		return 0;
	}

	private static int calculateSum (int page, int sum) {
		while (page > 0) {
			sum += page % 10 ;
			page /= 10;
		}
		return sum;
	}
}
