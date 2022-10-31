package onboarding.problemfive.domain;

import java.util.ArrayList;
import java.util.List;

public class Wallet {

	private static int[] currencies = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

	public static List<Integer> put(int money) {

		List<Integer> result = new ArrayList<>();

		for (int currency : currencies) {
			result.add(money / currency);
			money = money % currency;
		}
		return result;
	}

}
