package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {

	public static List<Integer> solution(int money) {
		List<Integer> answer = Collections.emptyList();

		answer = List.copyOf(convertMoney(money)); // money를 변환한 리스트를 answer 리스트에 복사

		return answer;
	}

	/**
	 * 기능 1 돈 변환 리스트 구하는 기능
	 */
	public static List<Integer> convertMoney(int money) {
		int[] moneyArray = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1}; //돈의 값이 담긴 배열

		List<Integer> wallet = new ArrayList<>();

		for (int i = 0; i < 9; i++) {
			wallet.add(money / moneyArray[i]);
			money %= moneyArray[i];
		}
		return wallet;
	}

}
