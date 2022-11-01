package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

	public static List<Integer> returnedMoney(int money, int[] moneyList) {
		int dividedMoney = 0;
		List<Integer> returnedMoneyList = new ArrayList<>();

		for (int m : moneyList) {
			dividedMoney = money/m;
			money = money%m;
			returnedMoneyList.add(dividedMoney);
		}
		return returnedMoneyList;
	}

    public static List<Integer> solution(int money) {
        // List<Integer> answer = Collections.emptyList();
		List<Integer> answer = new ArrayList<>();
		int[] moneyList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

		answer = returnedMoney(money, moneyList);

        return answer;
    }
}
