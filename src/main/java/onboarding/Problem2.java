package onboarding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
	public static String solution(String cryptogram) {
		Decoder decoder = new Decoder();
		return decoder.decode(cryptogram);
	}

	static class Decoder {

		private final static String REGEX = "(([a-z])\\2+)";

		private final Pattern pattern;

		Decoder() {
			this.pattern = Pattern.compile(REGEX);
		}

		public String decode(String cryptogram) {
			while (hasDuplicates(cryptogram)) {
				cryptogram = deleteDuplicates(cryptogram);
			}
			return cryptogram;
		}

		private boolean hasDuplicates(String cryptogram) {
			Matcher matcher = pattern.matcher(cryptogram);
			return matcher.find();
		}

		private String deleteDuplicates(String cryptogram) {
			return cryptogram.replaceAll(REGEX, "");
		}
	}
}
