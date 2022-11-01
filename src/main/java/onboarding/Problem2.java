package onboarding;

public class Problem2 {
	public static String solution(String cryptogram) {
		String answer = "";
		if (!restrictions(cryptogram)) {
			answer = deduplication(cryptogram);
		}
		return answer;
	}

	static boolean restrictions(String cryptogram) {
		if (!checkCryptogramLength(cryptogram.length()) || !checkCryptogramLowerCase(cryptogram)) {
			return true;
		}
		return false;
	}

	static boolean checkCryptogramLength(int i) {
		if (1 > i || 1000 < i) {
			return false;
		}
		return true;
	}

	private static boolean checkCryptogramLowerCase(String cryptogram) {
		char[] cryptogramSplit = cryptogram.toCharArray();
		for (int i = 0; i < cryptogramSplit.length; i++) {
			if (!Character.isLowerCase(cryptogramSplit[i])) {
				return false;
			}
		}
		return true;
	}

	static String deduplication(String crypto) {
		String[] cryptoArr = crypto.split("");
		String deduplCrypto = "";
		int count = 0;
		for (int i = 0; i < crypto.length(); i++) {
			if (i == 0 && !rightEqual(cryptoArr, i)) {
				deduplCrypto += cryptoArr[i];
			} else if (i == crypto.length() - 1 && !leftEqual(cryptoArr, i)) {
				deduplCrypto += cryptoArr[i];
			} else if (!leftEqual(cryptoArr, i) && !rightEqual(cryptoArr, i)) {
				deduplCrypto += cryptoArr[i];
			} else {
				count++;
			}
		}
		if (count == 0) {
			return deduplCrypto;
		}
		deduplCrypto = deduplication(deduplCrypto);

		return deduplCrypto;

	}

	static boolean rightEqual(String[] cryptoArr, int i) {
		if (i != cryptoArr.length - 1 && cryptoArr[i].equals(cryptoArr[i + 1])) {
			return true;
		}
		return false;
	}

	static boolean leftEqual(String[] cryptoArr, int i) {
		if (i != 0 && cryptoArr[i].equals(cryptoArr[i - 1])) {
			return true;
		}
		return false;
	}
	
}
