package onboarding;

public class Problem2 {
	public static String solution(String cryptogram) {
		return decode(cryptogram);
	}

	private static String decode(String cryptogram) {
		do {
			cryptogram = removeRepetition(cryptogram);
		} while (!cryptogram.equals("") && !cryptogram.equals(removeRepetition(cryptogram)));
		return cryptogram;
	}

	private static String removeRepetition(String cryptogram) {
		String result = "";
		result = result.concat(checkFirstLetter(cryptogram));

		for (int index = 1; index < cryptogram.length() - 1; index++) {
			result = result.concat(checkMiddleLetter(cryptogram, index));
		}
		result = result.concat(checkLastLetter(cryptogram));
		return result;
	}

	private static String checkFirstLetter(String cryptogram) {
		if (cryptogram.charAt(0) == cryptogram.charAt(1)) {
			return "";
		}
		return cryptogram.substring(0, 1);
	}

	private static String checkMiddleLetter(String cryptogram, int index) {
		if (cryptogram.charAt(index) == cryptogram.charAt(index - 1) || cryptogram.charAt(index) == cryptogram.charAt(
			index + 1)) {
			return "";
		}
		return cryptogram.substring(index, index + 1);
	}

	private static String checkLastLetter(String cryptogram) {
		if (cryptogram.charAt(cryptogram.length() - 1) == cryptogram.charAt(cryptogram.length() - 2)) {
			return "";
		}
		return cryptogram.substring(cryptogram.length() - 1);
	}
}
