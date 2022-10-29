package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

	/**
	 * 기능 목록 작성
	 * 1. 주어진 값을 화폐단위로 몇개씩 사용되는지 확인하는 기능
	 */
	public static List<Integer> solution(int money) {
		List<Integer> answer = new ArrayList<>();
		int[] moneys = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

		for (int won : moneys) {
			answer.add(money / won);
			money %= won;
		}

		return answer;
	}
}
