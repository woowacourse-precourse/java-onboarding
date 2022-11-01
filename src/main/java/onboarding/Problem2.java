package onboarding;

import java.util.NoSuchElementException;

public class Problem2 {
	public static String solution(String cryptogram) {
		return deleteDuplicate(cryptogram);
	}

	private static String deleteDuplicate(String cryptogram) {
		StringBuilder newCryptogram = new StringBuilder(cryptogram);
		while (isDuplicate(newCryptogram)) {
			int duplicateStart = getDuplicateStart(newCryptogram);
			int duplicateEnd = getDuplicateEnd(newCryptogram, duplicateStart);
			newCryptogram.delete(duplicateStart, duplicateEnd);
		}
		return newCryptogram.toString();
	}

	private static boolean isDuplicate(StringBuilder cryptogram) {
		for (int i = 1; i < cryptogram.length(); i++) {
			if (cryptogram.charAt(i - 1) == cryptogram.charAt(i)) {
				return true;
			}
		}
		return false;
	}

	private static int getDuplicateStart(StringBuilder cryptogram) {
		for (int i = 0; i < cryptogram.length(); i++) {
			if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
				return i;
			}
		}
		throw new NoSuchElementException();
	}

	private static int getDuplicateEnd(StringBuilder cryptogram, int duplicateStart) {
		for (int i = duplicateStart + 1; i < cryptogram.length(); i++) {
			if (cryptogram.charAt(duplicateStart) != cryptogram.charAt(i)) {
				return i;
			}
		}
		return cryptogram.length();
	}
}
