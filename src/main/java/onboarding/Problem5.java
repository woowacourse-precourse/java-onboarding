package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
	// 화폐 단위 리스트
	private static int[] amountArray = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

	public static List<Integer> solution(int money) {
		validateMoney(money) ;
		
		return getWithdrawalList(money);
	}

	/**
	 * 주어진 정수에 대한 유효성 검사
	 * @param money
	 */
	public static void validateMoney(int money) {
		if(money < 1 || money > 1000000) throw new IllegalArgumentException();
	}

	/**
	 * 인출 리스트를 반환한다.
	 * @param money
	 * @return
	 */
	public static List<Integer> getWithdrawalList(int money) {
		List<Integer> withdrawalList = new ArrayList<>();

		for(int amount : amountArray){
			// 화폐단위가 남은 금액보다 클 경우 해당 금액만큼 인출할 수 없기 때문에 0으로 값을 세팅
			if(amount > money) withdrawalList.add(0);
			// 화폐단위 만큼 남은 금액을 나눈 값을 세팅
			else withdrawalList.add(money / amount);
			// 화폐단위를 나눈 후 나머지 금액 세팅
			money %= amount;
		}
		
		return withdrawalList;
	}
}
