package onboarding;

import java.util.ArrayList;
import java.util.List;

import onboarding.problem5.CoinCalculator;
import onboarding.problem5.CoinList;
import onboarding.problem5.MoneyRangeValidator;

public class Problem5 {

	public static final String GUIDE = "money는 1이상 1_000_000이하이여야 합니다.";

	public static List<Integer> solution(int money) {
		MoneyRangeValidator moneyRangeValidator = new MoneyRangeValidator();
		if (!moneyRangeValidator.validate(money)) {
			throw new IllegalArgumentException(GUIDE);
		}

		List<Integer> answer = new ArrayList<>();
		CoinCalculator coinCalculator = new CoinCalculator();
		for (Integer coin : CoinList.getCoinList()) {
			answer.add(coinCalculator.calculatorCoinQuantity(money, coin));
			money = coinCalculator.calculatorCoinRest(money, coin);
		}

		return answer;
	}
}
