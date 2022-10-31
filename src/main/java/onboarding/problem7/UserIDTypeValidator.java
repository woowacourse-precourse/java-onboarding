package onboarding.problem7;

import java.util.regex.Pattern;

public class UserIDTypeValidator {
	private final Pattern userIDPattern = Pattern.compile("^[a-z]*$");
	public boolean validate(String userId) {
		return userIDPattern.matcher(userId).matches();
	}
}
