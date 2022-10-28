package onboarding;

import onboarding.problem5.Atm;

import java.util.List;

public class Problem5 {
	public static List<Integer> solution(int money) {
		Atm atm = new Atm();
		List<Integer> answer = atm.withdrawMoney(money);
		return answer;
	}
}
