package onboarding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {

	private static final String regex = "(\\w)(\\1+)";

	public static String solution(String cryptogram) {

		do {
			cryptogram = getFixedCryptogram(cryptogram);
		} while (doesDuplicationExist(cryptogram));

		return cryptogram;
	}

	private static String getFixedCryptogram(String cryptogram) {
		Matcher patternMatcher = setMatcher(cryptogram);
		cryptogram = removeDuplication(patternMatcher);
		return cryptogram;
	}

	private static boolean doesDuplicationExist(String cryptogram) {
		Matcher patternMatcher = setMatcher(cryptogram);
		return patternMatcher.find();
	}

	private static Matcher setMatcher(String cryptogram) {
		Pattern patternRegex = Pattern.compile(regex);
		return patternRegex.matcher(cryptogram);
	}

	private static String removeDuplication(Matcher patternMatcher) {
		String resultString;
		StringBuilder stringBuilder = new StringBuilder();

		while (patternMatcher.find()) {
			patternMatcher.appendReplacement(stringBuilder, "");
		}

		patternMatcher.appendTail(stringBuilder);
		resultString = String.valueOf(stringBuilder);

		return resultString;
	}
}
