package onboarding.problem3;

import java.util.ArrayList;
import java.util.List;

public class Game369 {
	private static final int MAX_NUMBER = 10000;
	private static List<Integer> game369SumList;

	private Game369() {

	}

	public static int getGame369sum(int n) {
		if (game369SumList == null) {
			game369SumList = new ArrayList<>();
			game369SumList.add(0);
			for (int i = 1; i < MAX_NUMBER + 1; i++) {
				game369SumList.add(game369SumList.get(i - 1) + IntegerFind369.getCount(i));
			}
		}
		return game369SumList.get(n);
	}
}
