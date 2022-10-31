package onboarding.problem5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Changer {
	public static final List<Integer> CURRENCY = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

	public static List<Integer> change(int money) {
		List<Integer> result = new ArrayList<>();
		for (Integer currency : CURRENCY) {
			result.add((int)Math.floor(money / currency));
			money %= currency;
		}
		return result;
	}
}
