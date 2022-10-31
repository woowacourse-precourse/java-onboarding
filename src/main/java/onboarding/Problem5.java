package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

	public enum Bill {
		FIFTYTHOUSAND(50000),
		TENTHOUSAND(10000),
		FIVETHOUSAND(5000),
		ONETHOUSAND(1000),
		FIVEHUNDRED(500),
		ONEHUNDRED(100),
		FIFTY(50),
		TEN(10),
		ONE(1);

		private final int price;

		private Bill(int price) {
			this.price = price;
		}

		public int getPrice() {
			return price;
		}
	}

	public static List<Integer> solution(int money) {
		List<Integer> answer = new ArrayList<>();
		for (Bill B : Bill.values()) {
			int curBill = B.getPrice();
			if (exchangeable(money, curBill)) {
				answer.add(exchangeBillCount(money, curBill));
				money = afterChange(money, curBill);
				continue;
			}
			answer.add(0);
		}
		return answer;
	}

	public static boolean exchangeable(int money, int curBill) {
		return money >= curBill;
	}

	public static int exchangeBillCount(int money, int curBill) {
		return money / curBill;
	}

	public static int afterChange(int money, int currBill) {
		return money % currBill;
	}
}
