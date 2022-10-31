package onboarding;

import java.util.NoSuchElementException;

public class Problem2 {
	public static String solution(String cryptogram) {
		return deleteDuplicate(cryptogram);
	}

	private static String deleteDuplicate(String cryptogram) {
		StringBuilder sb = new StringBuilder(cryptogram);
		while (isDuplicate(sb)) {
			int duplicateStart = getDuplicateStart(sb);
			int duplicateEnd = getDuplicateEnd(sb, duplicateStart);
			sb.delete(duplicateStart, duplicateEnd);
		}
		return sb.toString();
	}

	private static boolean isDuplicate(StringBuilder cryptogram) {
		for (int i = 1; i < cryptogram.length(); i++) {
			if (cryptogram.charAt(i - 1) == cryptogram.charAt(i)) {
				return true;
			}
		}
		return false;
	}

	private static int getDuplicateStart(StringBuilder sb) {
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == sb.charAt(i + 1)) {
				return i;
			}
		}
		throw new NoSuchElementException();
	}

	private static int getDuplicateEnd(StringBuilder sb, int duplicateStart) {
		for (int i = duplicateStart + 1; i < sb.length(); i++) {
			if (sb.charAt(duplicateStart) != sb.charAt(i)) {
				return i;
			}
		}
		return sb.length();
	}
}
