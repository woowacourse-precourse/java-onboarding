package onboarding.problem5;

import java.util.List;

public class AccountResponse {
	private List<Integer> numberOfCashList;

	public AccountResponse(List<Integer> numberOfCashList){
		this.numberOfCashList = numberOfCashList;
	}

	public List<Integer> getNumberOfCash() {
		return numberOfCashList;
	}

	public void addCashCount(int result) {
		this.numberOfCashList.add(result);
	}
}
