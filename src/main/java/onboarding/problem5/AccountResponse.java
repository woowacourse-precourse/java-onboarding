package onboarding.problem5;

import java.util.LinkedList;
import java.util.List;

public class AccountResponse {
	private List<Integer> resultList = new LinkedList<>();

	public List<Integer> getResultList() {
		return resultList;
	}

	public void addResult(int result) {
		resultList.add(result);
	}
}
