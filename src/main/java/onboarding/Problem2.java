package onboarding;

public class Problem2 {
	private static final String REPEAT_REGEX = "{2,}";
	private static final String REMOVE_BLANK = "";

	public static String solution(String cryptogram) {
		String plainText = cryptogram;
		int cryptogramLength;
		do {
			cryptogramLength = plainText.length();
			plainText = removeString(plainText);
		} while (checkMatching(cryptogramLength, plainText.length()));
		return plainText;
	}

	private static String removeString(String plainText) {
		for (char alphabet : plainText.toCharArray()) {
			plainText = plainText.replaceAll(alphabet + REPEAT_REGEX, REMOVE_BLANK);
		}
		return plainText;
	}

	private static boolean checkMatching(int cryptogram, int plainText) {
		return cryptogram == plainText;
	}
}
