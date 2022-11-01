package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
	// 현금인출기에서 종류별로 돈이 몇 개 나오는 지를 반환한다.
	public static List<Integer> solution(int money) {
		// 돈의 종류에 따라 인덱싱을 한다.
		List<Integer> moneyType = initMoneyType();
		// 입력한 돈을 종류에 따라 개수로 반환한다.
		List<Integer> tellerMachine = drawMoney(money, moneyType);
		return tellerMachine;
	}

	// 기능1. 돈의 종류에 따라 인덱싱을 한다.
	// 예를 들어 5만원은 인덱스 0번, 1만원은 인덱스 1번...
	private static List<Integer> initMoneyType() {
		List<Integer> moneyType =
			new ArrayList<>(List.of(50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1));
		return moneyType;
	}

	// 기능 2. 5만원부터 1원까지 순회하면서 종류별로 몇 개가 필요한지 계산한다.
	private static List<Integer> drawMoney(int money, List<Integer> moneyType) {
		List<Integer> tellerMachine = new ArrayList<>();
		for (int i = 0; i < moneyType.size(); i++) {
			// 이때 moneyType을 통해 인덱싱한 값을 이용하면 5만원부터
			// 순회하면서 money를 나눌 수 있다.
			int amountOfMoney = money / moneyType.get(i);
			if (amountOfMoney == 0) {
				tellerMachine.add(0);
				continue;
			}
			tellerMachine.add(amountOfMoney);
			// 몇 개 필요한지 계산 후 계산한 값만큼 돈을 제외시킨다.
			money %= moneyType.get(i);
		}
		return tellerMachine;
	}
}
