package onboarding;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Problem5 {
	
	public static List<Integer> solution(int money) {

		int[] monetaryUnits = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 };
		
		// ㅜ 불변 객체인 듯...
		List<Integer> answer = Collections.emptyList();
		List<Integer> countList = new ArrayList<Integer> (monetaryUnits.length);

		for (int i = 0; i < monetaryUnits.length; i++) {

			int quotient = getQuotient(money, monetaryUnits[i]);
			if (quotient >= 1) {

				money = money % monetaryUnits[i];
			}

			countList.add(i, quotient);
		}

		answer = countList;
		return answer;
	}

	//////////////////////////
	// ㅜ 나눗셈하여 몫을 구하는 함수
	public static int getQuotient(int money, int by) {

		int quotient = money / by;

		return quotient;
	}
}
