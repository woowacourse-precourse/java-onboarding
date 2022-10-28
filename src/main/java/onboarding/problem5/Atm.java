package onboarding.problem5;

import java.util.ArrayList;
import java.util.List;

public class Atm {
	List<Integer> changes;

	public Atm() {
		changes = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			changes.add(0);
		}
	}

	// 기능1. 지폐위주로 현금을 인출해준다.
	public List<Integer> withdrawMoney(int money) {
		convertMoney(money);
		return changes;
	}

	// 기능2. 인출해줄 지폐와 동전의 개수를 파악한다.
	public void convertMoney(int money) {
		int forConvert = money;
		while (money != 0) {
			if (money / 50000 != 0) {
				changes.set(0, money / 50000);
				money %= 50000;
			} else if (money / 10000 != 0) {
				changes.set(1, money / 10000);
				money %= 10000;
			} else if (money / 5000 != 0) {
				changes.set(2, money / 5000);
				money %= 5000;
			} else if (money / 1000 != 0) {
				changes.set(3, money / 1000);
				money %= 1000;
			} else if (money / 500 != 0) {
				changes.set(4, money / 500);
				money %= 500;
			} else if (money / 100 != 0) {
				changes.set(5, money / 100);
				money %= 100;
			} else if (money / 50 != 0) {
				changes.set(6, money / 50);
				money %= 50;
			} else if (money / 10 != 0) {
				changes.set(7, money / 10);
				money %= 10;
			} else if (money / 1 != 0) {
				changes.set(8, money / 1);
				money %= 1;
			}
		}
	}
}

