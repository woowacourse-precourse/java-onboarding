package onboarding;

import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int pobiLeftPage = pobi.get(0);
		int pobiRightPage = pobi.get(1);
		int crongLeftPage = crong.get(0);
		int crongRightPage= crong.get(1);

		int result = 0;
		if (pobiLeftPage % 2 == 0 || pobiRightPage % 2 == 1 || crongLeftPage % 2 == 0 || crongRightPage % 2 == 1) {
			result =  -1;
		}
		// int answer = Integer.MAX_VALUE;
		return result;
	}
}
