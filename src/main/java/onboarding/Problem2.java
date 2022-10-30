package onboarding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
	public static String solution(String cryptogram) {
		String answer;
		Matcher patternMatcher;

		while (true) {
			boolean doesDuplicationExists = checkDuplication(cryptogram);
			patternMatcher = setMatcher(cryptogram);
			cryptogram = removeDuplication(patternMatcher);

			if (!doesDuplicationExists) { break; }

		}

		answer = cryptogram;

		return answer;
	}

	private static boolean checkDuplication(String cryptogram) {
		Matcher patternMatcher = setMatcher(cryptogram);
		return patternMatcher.find();
	}

	private static Matcher setMatcher(String cryptogram) {
		String regex = "(\\w)(\\1+)";
		Pattern patternRegex = Pattern.compile(regex);
		return patternRegex.matcher(cryptogram);
	}

	private static String removeDuplication(Matcher patternMatcher) {
		String cryptogram;
		StringBuilder stringBuilder = new StringBuilder();

		while (patternMatcher.find()) {
			patternMatcher.appendReplacement(stringBuilder, "");
		}

		patternMatcher.appendTail(stringBuilder);
		cryptogram = String.valueOf(stringBuilder);

		return cryptogram;
	}
}
