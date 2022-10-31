package onboarding;

public class Problem2 {
	public static String solution(String cryptogram) {
		return deleteDuplicate(cryptogram);
	}

	private static String deleteDuplicate(String cryptogram) {
		StringBuilder sb = new StringBuilder(cryptogram);
		while (isDuplicate(sb)) {
			int duplicateStart = 0;
			int duplicateEnd = sb.length();
			for (int i = 0; i < sb.length(); i++) {
				if (sb.charAt(i) == sb.charAt(i + 1)) {
					duplicateStart = i;
					break;
				}
			}
			for (int i = duplicateStart + 1; i < sb.length(); i++) {
				if (sb.charAt(duplicateStart) != sb.charAt(i)) {
					duplicateEnd = i;
					break;
				}
			}
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
}
