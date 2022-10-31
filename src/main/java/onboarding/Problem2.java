package onboarding;

public class Problem2 {
	public static String solution(String cryptogram) {
		while (isDuplicate(cryptogram)) {
			int duplicateStart = 0;
			int duplicateEnd = cryptogram.length();
			for (int i = 0; i < cryptogram.length(); i++) {
				if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
					duplicateStart = i;
					break;
				}
			}
			for (int i = duplicateStart + 1; i < cryptogram.length(); i++) {
				if (cryptogram.charAt(duplicateStart) != cryptogram.charAt(i)) {
					duplicateEnd = i;
					break;
				}
			}
			cryptogram = cryptogram.substring(0, duplicateStart) + cryptogram.substring(duplicateEnd);
		}
		return cryptogram;
	}

	private static boolean isDuplicate(String cryptogram) {
		for (int i = 1; i < cryptogram.length(); i++) {
			if (cryptogram.charAt(i - 1) == cryptogram.charAt(i)) {
				return true;
			}
		}
		return false;
	}
}
