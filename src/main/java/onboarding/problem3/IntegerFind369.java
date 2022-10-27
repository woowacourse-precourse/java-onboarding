package onboarding.problem3;

import java.util.List;

public class IntegerFind369 {
	private final static List<Integer> numberList = List.of(3, 6, 9);

	public static int getCount(int n) {
		int count = 0;
		while (n > 0) {
			int rest = n % 10;
			if (numberList.contains(rest)) {
				count++;
			}
			n /= 10;
		}
		return count;
	}
}
