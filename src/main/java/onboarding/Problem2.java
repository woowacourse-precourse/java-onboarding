package onboarding;

public class Problem2 {
	public static String solution(String cryptogram) {
		String answer = "answer";
		answer = makeNewCryptogram(cryptogram);
		return answer;
	}

	public static String makeNewCryptogram(String cryptogram) {
		InputValidator.checkRightInput(cryptogram);
		String newCryptogram = cryptogram.substring(0, 1);
		int i = 1;
		while (i < cryptogram.length()) {
			String remainingCryptogram = cryptogram.substring(i);
			char lastCharOfNewCryptogram = newCryptogram.charAt(newCryptogram.length() - 1);

			newCryptogram = makeCryptogramByChar(i, cryptogram, newCryptogram);
			i += getNextIndexRange(lastCharOfNewCryptogram, remainingCryptogram);

			if (i < cryptogram.length() && newCryptogram.isEmpty()) {
				newCryptogram += cryptogram.charAt(i);
				i++;
			}
		}
		return newCryptogram;
	}

	private static String makeCryptogramByChar(int i, String cryptogram, String newCryptogram) {
		char nowChar = cryptogram.charAt(i);
		char lastCharOfNewCryptogram = newCryptogram.charAt(newCryptogram.length() - 1);

		if (nowChar == lastCharOfNewCryptogram) {
			return removeLastCharFromString(newCryptogram);
		}
		return newCryptogram + nowChar;
	}

	private static String removeLastCharFromString(String value) {
		return value.substring(0, value.length() - 1);
	}

	private static int getNextIndexRange(char checkChar, String remainingCryptogram) {
		int sameCharCount = getSameCharCount(checkChar, remainingCryptogram);
		if (sameCharCount > 0) {
			return sameCharCount;
		}
		return 1;
	}

	public static int getSameCharCount(char lastChar, String cryptogram) {
		int sameCharCount = 0;
		while (sameCharCount < cryptogram.length() && lastChar == cryptogram.charAt(sameCharCount)) {
			sameCharCount++;
		}
		return sameCharCount;
	}

	static class InputValidator {

		public static void checkRightInput(String cryptogram) {
			checkRightRange(cryptogram);
			checkCryptogramChar(cryptogram);
		}

		private static void checkRightRange(String cryptogram) {
			int cryptogramLength = cryptogram.length();
			if (cryptogramLength < 1 || cryptogramLength > 1000) {
				throw new IllegalArgumentException();
			}
		}

		private static void checkCryptogramChar(String cryptogram) {
			char[] charArray = cryptogram.toCharArray();
			for (int i = 0; i < charArray.length; i++) {
				checkLowerCase(charArray, i);
			}
		}

		private static void checkLowerCase(char[] charArray, int i) {
			if (!Character.isLowerCase(charArray[i])) {
				throw new IllegalArgumentException();
			}
		}
	}
}
