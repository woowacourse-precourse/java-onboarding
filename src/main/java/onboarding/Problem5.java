package onboarding;

import java.util.List;

import onboarding.problem5.Exchanger;

public class Problem5 {
	public static List<Integer> solution(int money) {
		Exchanger exchanger = new Exchanger();
		return exchanger.exchange(money);
	}
}
