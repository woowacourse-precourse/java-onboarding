package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

	private static final List<Integer> coins = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

	// 최종 결과를 반환하기 위한 solution 내부 코드 작성
	public static List<Integer> solution(int money) {
		List<Integer> answer;
		answer = coinsCount(money);
		
		return answer;
	}

	// 매개변수에서 지폐, 동전이 각 몇 개로 변환되는지 반환하는 메소드
	private static List<Integer> coinsCount(int money) {
		int coinCount;
		List<Integer> coinsCount = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0));

		for (int i = 0; i < coinsCount.size(); i++) {
			if (money == 0) {
				break;
			}
			coinCount = money / coins.get(i);
			money %= coins.get(i);
			coinsCount.set(i, coinCount);
		}

		return coinsCount;
	}

}