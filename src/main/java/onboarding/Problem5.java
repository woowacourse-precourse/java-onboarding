package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
	public static List<Integer> solution(int money) {

		List answer = new ArrayList();
		int moneyCount = 0;
		int wonUnit[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

		for (int i = 0; i < 9; i++) {
			moneyCount = money / wonUnit[i];
			money = money % wonUnit[i];
			answer.add(moneyCount);
		}

		return answer;
	}
}
