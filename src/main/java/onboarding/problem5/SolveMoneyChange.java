package onboarding.problem5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SolveMoneyChange {
	// 지폐 및 동전 단위
	// 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전
	private static final List<Integer> listMoneyQuota = Arrays.asList(50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1);
	private List<Integer> answer = Collections.emptyList();

	public List<Integer> changeMoney(int money) {
		List<Integer> answer = new ArrayList<>();
		for (Integer moneyQuota : listMoneyQuota) {
			Integer quotient = Math.floorDiv(money, moneyQuota);
			answer.add(quotient);
			money = money - (quotient * moneyQuota);
		}
		return answer;
	}
}
