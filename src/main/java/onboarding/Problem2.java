package onboarding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {

	/**
	 * 아래 표현식은 문자의 2 이상 중복을 식별한다.
	 * <p>
	 * 형식 : "<word><same-as-previous>"
	 */

	private static final String regex = "(\\w)(\\1+)";

	public static String solution(String cryptogram) {

		do {
			cryptogram = rearrangeString(setPatternMatcher(cryptogram));
		} while (doesDuplicationExist(cryptogram));

		return cryptogram;
	}


	private static boolean doesDuplicationExist(String cryptogram) {
		Matcher patternMatcher = setPatternMatcher(cryptogram);
		return patternMatcher.find();
	}

	private static Matcher setPatternMatcher(String cryptogram) {
		return setPattern(cryptogram);
	}

	private static Matcher setPattern(String cryptogram) {
		Pattern patternRegex = Pattern.compile(regex);
		return patternRegex.matcher(cryptogram);
	}

	private static String rearrangeString(Matcher patternMatcher) {
		String resultString;
		StringBuilder stringBuilder = new StringBuilder();

		removeString(patternMatcher, stringBuilder);

		patternMatcher.appendTail(stringBuilder);
		resultString = String.valueOf(stringBuilder);

		return resultString;
	}

	private static void removeString(Matcher patternMatcher, StringBuilder stringBuilder) {

		while (patternMatcher.find()) {
			patternMatcher.appendReplacement(stringBuilder, "");
		}

	}
}
