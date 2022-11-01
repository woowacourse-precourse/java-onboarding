package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
	public static List<Integer> solution(int money) {
		List<Integer> answer = Collections.emptyList();
		if (!restrictions(money)) {
			answer = conversion(money, 0);
		}
		return answer;
	}

	static boolean restrictions(int money) {
		if (1 > money || 1000000 < money) {
			return true;
		}
		return false;
	}

	static List<Integer> conversion(int money, int order) {
		List<Integer> coinsNum = new ArrayList<>();
		int[] coins = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 };
		int conversionCoincount = 0;
		for (int i = 0; i < coins.length; i++) {
			conversionCoincount = conversionCoin(money, coins[order]);
			coinsNum.add(conversionCoincount);
			money = restMoney(money, coins[order], conversionCoincount);
			order++;
		}

		return coinsNum;
	}

	static int conversionCoin(int money, int coin) {
		int coinCount;
		if (money - coin < 0) {
			return 0;
		} else {
			coinCount = money / coin;
			money = money - (coinCount * coin);
		}
		return coinCount;
	}

	static int restMoney(int money, int coin, int count) {
		int moneyConversion = money - (coin * count);
		return moneyConversion;
	}
	
}
