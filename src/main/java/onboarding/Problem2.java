package onboarding;

public class Problem2 {
	public static String solution(String cryptogram) {
		String answer = "answer";
		return answer;
	}

	static class InputValidator {

		public static void checkRightInput(String cryptogram) {
			checkRightRange(cryptogram);
			checkLowerCase(cryptogram);
		}

		private static void checkRightRange(String cryptogram) {
			int cryptogramLength = cryptogram.length();
			if (cryptogramLength < 1 || cryptogramLength > 1000) {
				throw new IllegalArgumentException();
			}
		}

		private static void checkLowerCase(String cryptogram) {
			char[] charArray = cryptogram.toCharArray();

			for (int i = 0; i < charArray.length; i++) {
				if (!Character.isLowerCase(charArray[i])) {
					throw new IllegalArgumentException();
				}
			}
		}
	}

}
