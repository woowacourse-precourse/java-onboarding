package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {

	public static List<Integer> solution(int money) {

		List<Integer> answer = Collections.emptyList();

		int[] monetaryUnits = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 };

		for (int won : monetaryUnits) {

			int quotient = getQuotient(money, won);
			if (quotient >= 1) {

				money = money % won;
			}

			answer.add(quotient);
		}

		return answer;
	}

	//////////////////////////
	// ㅜ 나눗셈하여 몫을 구하는 함수
	public static int getQuotient(int money, int by) {

		int quotient = money / by;

		return quotient;
	}
}
