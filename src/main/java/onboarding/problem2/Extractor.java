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

	public static String extract(String cryptogram) {
		int index = 0;
		while (index < cryptogram.length()) {
			int count = countSameNumber(cryptogram, index);
			if (count == 1) {
				index++;
			} else {
				cryptogram = cut(cryptogram, index, index + count - 1);
				index = Math.max(index - 1, 0);
			}
		}
		return cryptogram;
	}
}
