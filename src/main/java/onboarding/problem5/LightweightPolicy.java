package onboarding.problem5;

import java.util.ArrayList;
import java.util.List;

public class LightweightPolicy implements IPolicy{

	private final List<Integer> dividedPriceList = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

	@Override
	public AccountResponse withdraw(AccountRequest request) {
		int cash = request.getCashAmount();
		List<Integer> numberOfCashList = new ArrayList<>(dividedPriceList.size());
		AccountResponse accountResponse = new AccountResponse(numberOfCashList);

		for(int dividedCash : dividedPriceList){
			int result = (int) cash / dividedCash;
			accountResponse.addCashCount(result);
			cash -= result * dividedCash;
		}

		return accountResponse;
	}
}
