package onboarding.problem2;

public class Extractor {
	private static String cut(String str, int start, int end) {
		if (end == str.length() - 1) {
			return str.substring(0, start);
		}
		return str.substring(0, start) + str.substring(end + 1, str.length());
	}

	private static int countSameNumber(String str, int index) {
		char[] chars = str.toCharArray();
		char targetChar = chars[index];
		int count = 0;
		for (int i = index; i < chars.length; i++) {
			if (chars[i] != targetChar) {
				break;
			}
			count++;
		}
		return count;
	}
}
