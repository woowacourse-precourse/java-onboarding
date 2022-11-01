package onboarding.problem5;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Account {

	public static final int MIN_MONEY = 1;
	public static final int MAX_MONEY = 1000000;
	private int budget;

	public Account(int money) {
		validateMoney(money);
		this.budget = money;
	}

	private void validateMoney(int money) {
		if (money < MIN_MONEY || money > MAX_MONEY) {
			throw new IllegalArgumentException("돈의 액수는 1이상 1,000,000 이하인 자연수 입니다.");
		}
	}

	public List<Integer> withdraw() {
		MoneyUnit[] moneyUnits = MoneyUnit.values();
		return Arrays.stream(moneyUnits)
			.map(this::withdraw)
			.collect(Collectors.toList());
	}

	public int withdraw(MoneyUnit moneyUnit) {
		int count = moneyUnit.getCount(budget);
		budget %= moneyUnit.getUnit();
		return count;
	}
}
