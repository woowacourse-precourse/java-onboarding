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
		String tmp = "";
		tmp = tmp.concat(checkFirstLetter(cryptogram));

		for (int i = 1; i < cryptogram.length() - 1; i++) {
			tmp = tmp.concat(checkMiddleLetter(cryptogram, i));
		}
		tmp = tmp.concat(checkLastLetter(cryptogram));
		return tmp;
	}

	private static String checkFirstLetter(String cryptogram) {
		if (cryptogram.charAt(0) == cryptogram.charAt(1)) {
			return "";
		}
		return cryptogram.substring(0, 1);
	}

	private static String checkMiddleLetter(String cryptogram, int i) {
		if (cryptogram.charAt(i) == cryptogram.charAt(i - 1) || cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
			return "";
		}
		return cryptogram.substring(i, i + 1);
	}

	private static String checkLastLetter(String cryptogram) {
		if (cryptogram.charAt(cryptogram.length() - 1) == cryptogram.charAt(cryptogram.length() - 2)) {
			return "";
		}
		return cryptogram.substring(cryptogram.length() - 1);
	}
}
