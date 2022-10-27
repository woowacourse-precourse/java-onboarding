package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
	public static List<Integer> solution(int money) {
		ArrayList<Integer> answer = new ArrayList<>();
		int[] moneyPackage = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

		for (int i = 0; i < moneyPackage.length; i++) {
			int result = money / moneyPackage[i];
			answer.add(result);

			money %= moneyPackage[i];
		}

		return answer;
	}
}
