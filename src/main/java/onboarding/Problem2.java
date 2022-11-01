package onboarding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
	static Pattern pattern;

	public static void createRegexPattern() {
		String regex = "([a-z])\\1+";
		pattern = Pattern.compile(regex);
	}

	public static String deleteConsecutiveCharacters(String cryptogram) {
		Matcher matcher = pattern.matcher(cryptogram);
		String result = matcher.replaceAll("");
		return result;
	}

	public static String createAnswer(String answer, String tempAnswer) {
		while(true) {
			tempAnswer = deleteConsecutiveCharacters(tempAnswer);
			if (answer.equals(tempAnswer)) {
				break;
			}
			answer = tempAnswer;
		}
		return answer;
	}

    public static String solution(String cryptogram) {
		String answer = "answer";
		String tempAnswer = cryptogram;

		createRegexPattern();
		answer = createAnswer(answer, tempAnswer);
		return answer;
    }
}
