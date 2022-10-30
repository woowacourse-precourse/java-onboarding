package onboarding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
	public static String solution(String cryptogram) {

		String answer;
		String regex = "(\\w)(\\1+)";
		Pattern patternRegex = Pattern.compile(regex);

		while (true) {
			Matcher patternMatcher = patternRegex.matcher(cryptogram);
			StringBuilder stringBuilder = new StringBuilder();

			while (patternMatcher.find()) {
				patternMatcher.appendReplacement(stringBuilder, "");
			}
			patternMatcher.appendTail(stringBuilder);
			cryptogram = String.valueOf(stringBuilder);

			System.out.println(cryptogram);
			patternMatcher = patternRegex.matcher(cryptogram);
			if (!patternMatcher.find()) {
				answer = cryptogram;
				break;
			}
		}
		return answer;
	}
}
