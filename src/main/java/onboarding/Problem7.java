package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		List<String> answer = Collections.emptyList();
		return answer;
	}

	static class InputValidator {

		public static void checkRightInput(String user, List<List<String>> friends, List<String> visitors) {
			isRightUserInput(user);
		}

		public static boolean isRightUserInput(String user) {
			checkRightUserRange(user);
			checkUserLowerCase(user);
			return true;
		}

		public static void checkRightUserRange(String user) {
			if (user.length() < 1 || user.length() > 30) {
				throw new IllegalArgumentException();
			}
		}

		public static void checkUserLowerCase(String user) {
			char[] charArray = user.toCharArray();

			for (int i = 0; i < charArray.length; i++) {
				if (!Character.isLowerCase(charArray[i])) {
					throw new IllegalArgumentException();
				}
			}
		}
	}
}
