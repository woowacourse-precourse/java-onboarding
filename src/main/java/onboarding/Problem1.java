package onboarding;

import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		PageNumberGame pageNumberGame = new PageNumberGame(pobi, crong);
		int answer = pageNumberGame.run();
		return answer;
	}
}
