package onboarding.problem5;

public class LightweightPolicy implements IPolicy{

	@Override
	public AccountResponse withdraw(AccountRequest request) {
		int cash = request.getCashAmount();
		int dividedCash = 100000;
		int[] dividedNumber = {2, 5, 10};
		int index = 0;

		AccountResponse accountResponse = new AccountResponse();

		while(dividedCash > 1){
			if(dividedCash == 10){
				index = 2;
			}

			dividedCash /= dividedNumber[index];
			int result = (int) cash / dividedCash;
			accountResponse.addResult(result);
			cash -= result * dividedCash;
			index++;

			if(index >= 2){
				index = 0;
			}
		}

		return accountResponse;
	}
}
