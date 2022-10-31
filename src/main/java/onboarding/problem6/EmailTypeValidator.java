package onboarding.problem6;

import java.util.regex.Pattern;

public class EmailTypeValidator {
	private final Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9]*@email.com$");

	public boolean validate(String email) {
		return emailPattern.matcher(email).matches();
	}
}
