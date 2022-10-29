package onboarding;

import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;
		
		if (SeparateDigit.isWrongPage(pobi)
				|| SeparateDigit.isWrongPage(crong)) {
			answer = -1;
			return answer;
		}
		SeparateDigit pobiDigit = new SeparateDigit(pobi);
		SeparateDigit crongDigit = new SeparateDigit(crong);
		
		answer = pobiDigit.compareScore(crongDigit);
		return answer;
	}
}