package onboarding.problem2;

public class Extractor {
	private static String cut(String str, int start, int end) {
		if (end == str.length() - 1) {
			return str.substring(0, start);
		}
		return str.substring(0, start) + str.substring(end + 1, str.length());
	}
}
