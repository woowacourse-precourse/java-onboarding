package onboarding.problem2;

import java.util.regex.Pattern;

public class CheckCrytogram {
	private final static int limit = 1000;

	public static boolean of(String cryptogram) {
		if (cryptogram == null) {
			throw new IllegalArgumentException("cryptogram가 null이면 안됩니다.");
		}

		if (cryptogram.length() > limit) {
			throw new IllegalArgumentException("cyptogram은 " + limit + " 초과하면 안됩니다.");
		}
		for (char c : cryptogram.toCharArray()) {
			if (!Pattern.matches("[a-z]", String.valueOf(c))) {
				throw new IllegalArgumentException("cyptogram은 모두 소문자여야 합니다.(a~z)");
			}
		}

		return true;
	}
}
