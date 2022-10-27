package onboarding;

public class Problem4 {

	private static final char[] upperAlphaDictionary = {'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P', 'O', 'N',
		'M', 'L', 'K', 'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'};
	private static final char[] lowerAlphaDictionary = {'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n',
		'm', 'l', 'k', 'j', 'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a'};

	public static String solution(String word) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < word.length(); i++) {
			char alpha = word.charAt(i);
			if (isUpper(alpha)) {
				sb.append(upperAlphaDictionary[alpha - 'A']);
				continue;
			} else if (isLower(alpha)) {
				sb.append(lowerAlphaDictionary[alpha - 'a']);
				continue;
			}
			sb.append(word.charAt(i));
		}
		return sb.toString();
	}

	private static boolean isLower(char alpha) {
		return alpha >= 'a' && alpha <= 'z';
	}

	private static boolean isUpper(char alpha) {
		return alpha >= 'A' && alpha <= 'Z';
	}

}
