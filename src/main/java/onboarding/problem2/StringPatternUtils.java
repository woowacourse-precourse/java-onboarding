package onboarding.problem2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPatternUtils {
	private static final String LOWER_CASE_PATTERN = "^[a-z]*$";

	public static boolean isFormedLowerCase(String input) {
		Pattern compile = Pattern.compile(LOWER_CASE_PATTERN);
		Matcher matcher = compile.matcher(input);
		return matcher.matches();
	}
}
