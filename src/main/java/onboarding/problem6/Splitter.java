package onboarding.problem6;

import java.util.LinkedHashSet;
import java.util.Set;

public class Splitter {
	public static Set<String> splitTwoChar(String str) {
		Set<String> result = new LinkedHashSet<>();
		for (int i = 0; i < str.length() - 1; i++) {
			result.add(str.substring(i, i + 2));
		}
		return result;
	}
}
