package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
	public static List<Integer> solution(int money) {
		Exchanger exchanger = new Exchanger();
		return exchanger.exchange(money);
	}

	static class Exchanger {

		private static final List<Integer> CHANGE_LIST = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

		public List<Integer> exchange(int money) {
			List<Integer> changeList = new ArrayList<>();

			for (Integer change : CHANGE_LIST) {
				changeList.add(money / change);
				money = money % change;
			}
			return changeList;
		}
	}
}
