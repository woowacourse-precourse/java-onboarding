package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
		if (!isValidNumber(money)) {
			return Collections.emptyList();
		}

	private static boolean isValidNumber(int money) {
		return money >= 1 && money <= 1000000;
	}

        return answer;
    }
}
