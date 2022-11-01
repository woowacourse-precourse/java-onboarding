package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Problem1 {

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;

		// 1. 책을 임의로 펼친다.
		int pRandom = (int) ((Math.random() * 400) + 1);
		int cRandom = (int) ((Math.random() * 400) + 1);

		if (pRandom % 2 == 1) {
			pobi.add(0, pRandom);
			pobi.add(1, pRandom + 1);
		} else if (pRandom % 2 == 0) {
			pobi.add(0, pRandom - 1);
			pobi.add(1, pRandom);
		}

		if (cRandom % 2 == 1) {
			crong.add(0, cRandom);
			crong.add(1, cRandom + 1);
		} else if (pRandom % 2 == 0) {
			crong.add(0, cRandom - 1);
			crong.add(1, cRandom);
		}



		return answer;
	}
}