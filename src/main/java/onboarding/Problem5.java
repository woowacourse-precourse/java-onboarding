package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

	private static class Bank {
		private enum Money {
			FIFTY_THOUSAND(50000),
			TEN_THOUSAND(10000),
			FIVE_THOUSAND(5000),
			ONE_THOUSAND(1000),
			FIVE_HUNDRED(500),
			ONE_HUNDRED(100),
			FIFTY(50),
			TEN(10),
			ONE(1);

			private final int price;
			Money(int price) {
				this.price = price;
			}
		}
	}
}
