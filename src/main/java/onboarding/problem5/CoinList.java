package onboarding.problem5;

import java.util.List;

public class CoinList {
	private static final List<Integer> coinList = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

	public static List<Integer> getCoinList() {
		return coinList;
	}
}
